package org.javx;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;

public class Javx {
	public Javx()  {
		String os = System.getProperty("os.name");
		String libName;
		if (os.contains("Win")) {
			libName = "javx.dll";
		}
		else {
			libName = "libjavx.so"; 
		}
		URL url = Javx.class.getResource("/" + libName);
		File tmpDir;
		try {
			tmpDir = Files.createTempDirectory("javx").toFile();
			tmpDir.deleteOnExit();
			File nativeLibTmpFile = new File(tmpDir, libName);
			nativeLibTmpFile.deleteOnExit();
			try (InputStream in = url.openStream()) {
				Files.copy(in, nativeLibTmpFile.toPath());
			}
			System.load(nativeLibTmpFile.getAbsolutePath());
		} 
		catch (IOException e) {
			e.printStackTrace();
			//System.exit(1);
		}
	}
	  
	public native int[] add_int(int[] a, int[] b);
}
