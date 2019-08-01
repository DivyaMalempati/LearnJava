import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {
	@Test
	public void insert_NewNode_AtFirst_Test() {
		LinkedList linkedList = new LinkedList();
		assertTrue(linkedList.isEmpty());
		assertEquals(0, linkedList.size());
		assertTrue(linkedList.add(10));
		assertEquals(1, linkedList.size());
		assertTrue(linkedList.addAtFirst(5));
		assertEquals(2, linkedList.size());
		assertArrayEquals(new Integer[] { 5, 10 }, linkedList.toArray());
		assertEquals("[5,10]", linkedList.toString());
	}

	@Test
	public void insert_NewNode_AtLast_Test() {
		LinkedList linkedList = new LinkedList();
		assertTrue(linkedList.add(10));
		assertEquals(1, linkedList.size());
		assertFalse(linkedList.isEmpty());
		assertTrue(linkedList.add(20));
		assertEquals(2, linkedList.size());
		assertArrayEquals(new Integer[] { 10, 20 }, linkedList.toArray());
		assertTrue(linkedList.add(30));
		assertEquals(3, linkedList.size());
		assertArrayEquals(new Integer[] { 10, 20, 30 }, linkedList.toArray());
		assertTrue(linkedList.add(40));
		assertEquals(4, linkedList.size());
		assertArrayEquals(new Integer[] { 10, 20, 30, 40 }, linkedList.toArray());
	}

	@Test
	public void insert_NewNode_AtIndex_Test() {
		LinkedList linkedList = new LinkedList();
		assertTrue(linkedList.add(10));
		assertEquals(1, linkedList.size());
		assertFalse(linkedList.isEmpty());
		assertTrue(linkedList.add(20));
		assertEquals(2, linkedList.size());
		assertArrayEquals(new Integer[] { 10, 20 }, linkedList.toArray());
		assertTrue(linkedList.add(30));
		assertEquals(3, linkedList.size());
		assertArrayEquals(new Integer[] { 10, 20, 30 }, linkedList.toArray());
		assertTrue(linkedList.add(40));
		assertEquals(4, linkedList.size());
		assertArrayEquals(new Integer[] { 10, 20, 30, 40 }, linkedList.toArray());
		linkedList.add(0, 1);
		assertEquals(5, linkedList.size());
		assertArrayEquals(new Integer[] { 1, 10, 20, 30, 40 }, linkedList.toArray());
		linkedList.add(2, 15);
		assertEquals(6, linkedList.size());
		assertArrayEquals(new Integer[] { 1, 10, 15, 20, 30, 40 }, linkedList.toArray());
		linkedList.add(5, 35);
		assertArrayEquals(new Integer[] { 1, 10, 15, 20, 30, 35, 40 }, linkedList.toArray());
		assertEquals(7, linkedList.size());
	}

	@Test
	public void remove_Node_AtFirst_Test() {
		LinkedList linkedList = new LinkedList();
		assertTrue(linkedList.add(1));
		assertArrayEquals(new Integer[] { 1 }, linkedList.toArray());
		linkedList.add(1, 5);
		assertArrayEquals(new Integer[] { 1, 5 }, linkedList.toArray());
		assertTrue(linkedList.add(10));
		assertArrayEquals(new Integer[] { 1, 5, 10 }, linkedList.toArray());
		assertTrue(linkedList.add(20));
		assertArrayEquals(new Integer[] { 1, 5, 10, 20 }, linkedList.toArray());
		assertEquals(4, linkedList.size());
		assertEquals((Integer) 5, linkedList.remove(1));
		assertEquals((Integer) 1, linkedList.remove(0));
		assertEquals(2, linkedList.size());
	}
}
