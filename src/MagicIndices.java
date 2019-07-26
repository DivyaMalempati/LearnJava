import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.ArrayList;

public class MagicIndices {

	@Test
	public void findMagicIndices_SingleElement_Test() {
		int[] array = { 0 };
		List<Integer> magicArray = new ArrayList<Integer>();
		magicArray.add(0);
		assertEquals(magicArray, findMagicIndices(array));
	}

	@Test
	public void findMagicIndices_TwoElement_Test() {
		int[] array = { 0, 1 };
		List<Integer> magicArray = new ArrayList<Integer>();
		magicArray.add(0);
		magicArray.add(1);
		assertEquals(magicArray, findMagicIndices(array));
	}

	@Test
	public void findMagicIndices_NoMagicIndicesElement_Test() {
		int[] array = { -1,0,1 };
		List<Integer> magicArray = new ArrayList<Integer>();
		assertEquals(magicArray, findMagicIndices(array));
	}

	public List<Integer> findMagicIndices(int[] array) {
		List<Integer> magicArray = new ArrayList<Integer>();
		for (int index = 0; index < array.length; index++) {
			if (index == array[index]) {
				magicArray.add(index);
			}
		}
		return magicArray;

	}
}