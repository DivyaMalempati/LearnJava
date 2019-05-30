import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTest {

	@Test
	public void isEmptyTest() {
		Array array = new Array();
		assertTrue(array.isEmpty());
	}

	@Test
	public void addTest() {
		Array array = getArray(11);
		array.add(2, 14);
		assertEquals(12, array.size());
		assertFalse(array.isEmpty());
		array.add(4, 10);
		array.add(10, 35);
		array.add(6, 18);

	}

	@Test
	public void containsTest() {
		Array array = new Array();
		array.add(5);
		assertTrue(array.contains(5));
		assertFalse(array.contains(10));

	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void add_ElementAtIndex_OutOfBoundExceptionTest() {
		Array array = new Array();
		array.add(100, 3);
	}

	@Test
	public void indexOfTest() {
		Array array = getArray(10);
		assertEquals(5, array.indexOf(5));
		assertEquals(5, array.set(5, 15).intValue());
	}

	private Array getArray(int size) {
		Array array = new Array();
		for (int i = 0; i < size; i++) {
			array.add(i);
		}
		return array;
	}

	@Test
	public void lastIndexOfTest() {
		Array array = getArray(10);
		array.add(5);
		array.add(3);
		assertEquals(0, array.lastIndexOf(0));
		assertEquals(1, array.lastIndexOf(1));
		assertEquals(11, array.lastIndexOf(3));
		assertEquals(-1, array.lastIndexOf(20));
		assertEquals(-1, array.lastIndexOf(-1));
	}

	@Test
	public void removeTest() {
		Array array = getArray(10);
		assertEquals(3, array.remove(3).intValue());
		assertEquals(4, array.remove(3).intValue());
		assertEquals(5, array.remove(3).intValue());
		assertEquals(6, array.remove(3).intValue());
		assertEquals(7, array.remove(3).intValue());
		array.add(10);
		assertEquals(8, array.remove(3).intValue());

	}
}
