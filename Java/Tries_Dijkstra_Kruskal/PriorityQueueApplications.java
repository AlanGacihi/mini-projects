

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueApplications {

	public static ArrayList<Student> topK(ArrayList<Student> students, int k) { 
		// complete this method
		if (k > students.size())
			k = students.size();
		
		PriorityQueue<Student> heap = new PriorityQueue<>(new StudentComparator());
		for (int i = 0; i < k; i++) {
			heap.add(students.get(i));
		}

		StudentComparator comparator= new StudentComparator();
		for (int i = k; i < students.size(); i++) {
			Student min = heap.peek();
			Student current = students.get(i);
			if (comparator.compare(min, current) < 0) {
				heap.remove();
				heap.add(current);
			}
		}

		ArrayList<Student> topk = new ArrayList<Student>();
		while (heap.size() > 0) {
			Student ele = heap.peek();
			topk.add(ele);
			heap.remove();
		}
		return topk;
	}

	public static ArrayList<Integer> kWayMerge(ArrayList<ArrayList<Integer>> lists) { 
		
		// complete this method
		PriorityQueue<PriorityQueuePair> heap = new PriorityQueue<>(new PriorityQueuePairComparator());

		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < lists.size(); i++) {
			PriorityQueuePair pair = new PriorityQueuePair(i, lists.get(i).get(0));
			heap.add(pair);
		}

		int[] indexes = new int[lists.size()];
		for (int i = 0; i < indexes.length; i++)
			indexes[i] = 1;

		while (heap.size() > 0) {
			PriorityQueuePair min = heap.peek();
			heap.remove();
			numbers.add(min.priority);
			int minItem = min.item;

			if (indexes[minItem] < lists.get(minItem).size()) {
				heap.add(new PriorityQueuePair(minItem, lists.get(minItem).get(indexes[minItem])));
				indexes[minItem]++;
			}
		}
		return numbers;

	}
}
