package com.divya.java.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetImpl implements Set<Integer> {
	private ArrayListImpl array = new ArrayListImpl();

	@Override
	public int size() {
		return array.size();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public boolean contains(Object element) {
		if (array.contains(element)) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		return array.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {

		return null;
	}

	@Override
	public boolean add(Integer e) {
		if (!contains(e)) {
			int index = findRightLocation(e);
			if (index == -1) {
				array.add(e);
			} else {
				array.add(index, e);
			}
			return true;
		}
		return false;
	}

	private int findRightLocation(Integer e) {
		for (int index = 0; index < size(); index++) {
			if (array.get(index) >= e) {
				return index;
			}
		}
		return -1;
	}

	private void sortedSet(Integer e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remove(Object o) {
		if (contains(o)) {
			array.remove(o);
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return array.toString();
	}
}
