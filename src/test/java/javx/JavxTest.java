package javx;

import java.util.stream.IntStream;

import org.javx.Javx;
import org.junit.Assert;
import org.junit.Test;

public class JavxTest {

	@Test
	public void testBasic() {
		Javx j = new Javx();
		int[] b = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] a = {4, 2, 7, 4, 9, 6, 7, 8};
		int[] c = j.add_int(a, b);
		int[] control = new int[8];
		for (int i = 0; i < 8; i++) {
			control[i] = a[i] + b[i];
		}
		Assert.assertArrayEquals(control, c);
	}
	
	@Test
	public void testMultiple() {
		Javx j = new Javx();
		int size = 8*256;
		int[] b = IntStream.range(0, size).toArray();
		int[] a = IntStream.range(0, size).map(i -> i * i + 1).toArray();
		int[] c = j.add_int(a, b);
		int[] control = new int[size];
		for (int i = 0; i < size; i++) {
			control[i] = a[i] + b[i];
		}
		Assert.assertArrayEquals(control, c);
	}
}
