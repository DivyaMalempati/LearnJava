class StoreAndSearchArray {
	private int numberOfElementsInAnArray = 0;
	private int[] array;

	public StoreAndSearchArray(int size) {
		array = new int[size];
	}
	
	public void add(int i) {
		array[numberOfElementsInAnArray] = i;
		numberOfElementsInAnArray++;
	}

	public boolean contains(int element) {
		for (int index = 0; index < numberOfElementsInAnArray; index++) {
			if (array[index] == element) {
				return true;
			}
		}
		return false;
	}
}
