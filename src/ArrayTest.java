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
	public void setTest() {
		
	}
}
