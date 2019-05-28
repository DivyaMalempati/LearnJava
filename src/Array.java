import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Array implements List<Integer> {
	private static final int ARRAY_DEFAULT_SIZE = 5;
	int[] array;
	int numberOfElementsInArray;

	Array() {
		this(ARRAY_DEFAULT_SIZE);
	}

	Array(int intitalSize) {
		array = new int[intitalSize];
		numberOfElementsInArray = 0;
	}

	@Override
	public boolean add(Integer arg0) {
		doubleArraySizeIfNeededForAddingAnElement();
		array[numberOfElementsInArray] = arg0;
		numberOfElementsInArray++;
		return true;
	}

	private void doubleArraySize() {
		int[] newArray = new int[array.length * 2];
		for (int index = 0; index < numberOfElementsInArray; index++) {
			newArray[index] = array[index];
		}
		array = newArray;
	}

	@Override
	public void add(int arg0, Integer arg1) {
		doubleArraySizeIfNeededForAddingAnElement();
		if (arg0 <= numberOfElementsInArray) {
			for (int index = numberOfElementsInArray; index >= arg0; index--) {
				array[index + 1] = array[index];
			}
			numberOfElementsInArray++;
			array[arg0] = arg1;
		} else if (arg0 > numberOfElementsInArray) {
			throw new ArrayIndexOutOfBoundsException(arg0);
		}
	}

	private void doubleArraySizeIfNeededForAddingAnElement() {
		if (numberOfElementsInArray == array.length) {
			doubleArraySize();
		}
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
		if(indexOf(arg0)>=0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer get(int arg0) {
		return array[arg0];
	}

	@Override
	public int indexOf(Object arg0) {
		for (int i = 0; i < numberOfElementsInArray; i++) {
			if (arg0.equals(array[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return numberOfElementsInArray == 0 ? true : false;
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
		Integer previousElement=array[arg0];
		if (arg0 < numberOfElementsInArray) {
			array[arg0] = arg1;
		} else if (arg0 > numberOfElementsInArray) {
			throw new ArrayIndexOutOfBoundsException(arg0);
		}
		return previousElement;
	}

	@Override
	public int size() {
		return numberOfElementsInArray;
	}

	@Override
	public List<Integer> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
