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
		System.out.println(linkedList);
		assertTrue(linkedList.add(30));
		assertEquals(3, linkedList.size());
		System.out.println(linkedList);
		assertTrue(linkedList.add(40));
		assertEquals(4, linkedList.size());
		System.out.println(linkedList);
	}

}
