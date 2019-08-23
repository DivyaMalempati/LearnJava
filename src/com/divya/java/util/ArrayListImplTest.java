package com.divya.java.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ArrayListImplTest {
	ArrayListImpl array = new ArrayListImpl();

	@Test
	public void ArrayImpl_isEmpty_Test() {
		assertTrue(array.isEmpty());
	}

	@Test
	public void ArrayImpl_addremove_Test() {
		assertEquals(0, array.size());
		assertEquals(10, array.arraySize());
		array.add(10);
		assertEquals(1, array.size());
		assertEquals((Integer) 10, array.remove());
		array.add(10);
		array.add(20);
		array.add(30);
		array.add(40);
		array.add(50);
		array.add(60);
		array.add(70);
		array.add(80);
		array.add(90);
		array.add(100);
		array.add(110);
		assertEquals((Integer) 10, array.set(0, 1));
		assertEquals(11, array.size());
		assertEquals(20, array.arraySize());
		assertEquals((Integer) 110, array.remove());
		assertEquals(10, array.size());
		assertEquals((Integer) 100, array.remove());
		assertEquals(9, array.size());
		assertEquals(10, array.arraySize());
		assertEquals((Integer) 1, array.remove(0));
		assertEquals(8, array.size());
		assertEquals((Integer) 90, array.remove());
		assertEquals((Integer) 80, array.remove());
		assertEquals((Integer) 70, array.remove());
		assertEquals((Integer) 60, array.remove());
		assertEquals((Integer) 50, array.remove());
		assertEquals(3, array.size());
		assertEquals((Integer) 40, array.remove());
		assertEquals((Integer) 30, array.remove());
		assertEquals((Integer) 20, array.remove());
		assertEquals(0, array.size());
		assertTrue(array.isEmpty());
		assertThrows(RuntimeException.class, () -> {
			array.remove();
		});
	}

	@Test
	public void arrayListImpl_addAtIndex_Test() {
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(0, 10);
		assertEquals(5, array.size());
	}
}
