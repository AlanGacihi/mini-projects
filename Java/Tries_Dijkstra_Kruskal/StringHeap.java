

import java.util.ArrayList;
import java.util.Collections;

public class StringHeap {

	private ArrayList<String> heapArray;
	
	public StringHeap() {
		heapArray = new ArrayList<String>();
		
	}

	public String top() {
		return heapArray.get(0);
	}

	private void swap(int index1, int index2) { 
		// complete this method

		String tmp;
        tmp = heapArray.get(index1);
        heapArray.set(index1, heapArray.get(index2));
        heapArray.set(index2, tmp);
	}

	public void insert(String value) { 
		// complete this method
		heapArray.add(value);
		Collections.sort(heapArray, new StringComparator());
	}

	public void extract() { 
		// complete this method
		heapArray.remove(0);
		
	}

	public static void heapSort(String array[], int arrayLen) throws Exception { 
		
		// complete this method
		StringHeap heap = new StringHeap();
		for (int i = 0; i < arrayLen; i++) {
			heap.insert(array[i]);
		}

		for (int i = 0; i < arrayLen; i++) {
			array[i] = heap.top();
			heap.extract();
		}

	}

	public int size() {
		return heapArray.size();
	}

	public String toString() {
		return heapArray.toString();
	}
}
