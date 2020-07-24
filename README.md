# javx
JAVX: Java AVX library for native vector calculations.

Currently only supports vector addition of integer arrays, although extension to all operations is trivial.

Usage example:
```
		Javx j = new Javx();
		int[] b = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] a = {4, 2, 7, 4, 9, 6, 7, 8};
		int[] c = j.add_int(a, b); 
```
