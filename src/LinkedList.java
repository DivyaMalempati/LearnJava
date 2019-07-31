import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class LinkedList implements List<Integer> {
	private LinkedListNode head;
	private int sizeOfTheLinkedList;

	LinkedList() {
		head = null;
		sizeOfTheLinkedList = 0;
	}

	private static class LinkedListNode {
		LinkedListNode next;
		Integer element;

		LinkedListNode(Integer element) {
			this.element = element;
			next = null;
		}
	}

	@Override
	public boolean add(Integer arg0) {
		if (addAtLast(arg0)) {
			return true;
		}
		return false;
	}

	/**
	 * Time Complexities for AddAtLast is O(n)
	 * 
	 * @param element
	 *            to Add at last
	 */
	private boolean addAtLast(Integer element) {
		LinkedListNode newNode = createNewNode(element);
		if (head == null) {
			head = newNode;
			sizeOfTheLinkedList++;
			return true;
		} else {
			LinkedListNode lastNode = head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
			sizeOfTheLinkedList++;
			return true;
		}
	}

	/**
	 * creating a node and adding element to that Node
	 * 
	 * @param creating
	 *            an object to add an element
	 * @return
	 */
	private LinkedListNode createNewNode(Integer element) {
		LinkedListNode newNode = new LinkedListNode(element);
		return newNode;
	}

	/**
	 * Adding at First
	 * 
	 * @param element
	 */
	public boolean addAtFirst(Integer element) {
		LinkedListNode newNode = createNewNode(element);
		newNode.next = head;
		head = newNode;
		sizeOfTheLinkedList++;
		return true;
	}

	@Override
	public void add(int arg0, Integer arg1) {

	}

	@Override
	public boolean addAll(Collection<? extends Integer> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends Integer> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
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
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Integer> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Integer> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer set(int arg0, Integer arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		/*
		 * LinkedListNode currentNode = head; int count = 0; while (currentNode != null)
		 * { count++; currentNode = currentNode.next; } return count;
		 */
		return sizeOfTheLinkedList;
	}

	@Override
	public List<Integer> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		Integer[] array= new Integer[sizeOfTheLinkedList];
		LinkedListNode currentNode=head;
		int index=0;
		while(currentNode!=null) {
			array[index++]=currentNode.element;
			currentNode=currentNode.next;
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		LinkedListNode currentNode = head;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		while (currentNode != null) {
			stringBuilder.append(currentNode.element);
			currentNode = currentNode.next;
			if (currentNode != null) {
				stringBuilder.append(",");
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}