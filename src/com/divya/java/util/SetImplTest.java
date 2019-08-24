package com.divya.java.util;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import org.junit.jupiter.api.Test;

class SetImplTest {

	@Test
	void Set_isEmpty_Test() {
		Set<Integer> set = new SetImpl();
		assertEquals(0, set.size());
		System.out.println("Adding 10");
		set.add(10);
		assertFalse(set.add(10));
		assertEquals(1, set.size());
		System.out.println("Adding 1");
		set.add(1);
		System.out.println("Adding 2");
		set.add(2);
		System.out.println("Adding 5");
		set.add(5);
		System.out.println("Adding 3");
		set.add(3);
		System.out.println("Adding 4");
		set.add(4);
		assertEquals(6, set.size());
		// System.out.println(set);
	}

}
