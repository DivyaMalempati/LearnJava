package com.divya.learnjava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Comparing2Lists {
	public void compareListsUsingBuiltInMethods(List<Integer> L1, List<Integer> L2) {
		HashSet<Integer> hashL1 = new HashSet<>();
		HashSet<Integer> hashL2 = new HashSet<>();
		for (Integer integer : L1) {
			hashL1.add(integer);
		}
		for (Integer integer : L2) {
			hashL2.add(integer);
		}
		for (Integer integer : L1) {
			if (!hashL2.contains(integer)) {
				System.out.println(integer);
			}
		}
		for (Integer integer : L2) {
			if (!hashL1.contains(integer)) {
				System.out.println(integer);
			}
		}

	}

	@Test
	public void comparingListsTest() {
		List<Integer> L1 = new ArrayList<>();
		L1.add(1);
		L1.add(5);
		L1.add(2);
		L1.add(6);
		L1.add(3);
		L1.add(10);
		List<Integer> L2 = new ArrayList<>();
		L2.add(1);
		L2.add(3);
		L2.add(5);
		L2.add(6);
		L2.add(2);
		L2.add(7);
		compareListsUsingBuiltInMethods(L1, L2);
	}
}
