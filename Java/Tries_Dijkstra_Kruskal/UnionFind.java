

import java.util.ArrayList;

public class UnionFind {

	private ArrayList<ArrayList<Integer>> representatives;

	public UnionFind(int initialNumSets) { // complete this constructor
		representatives = new ArrayList<>(initialNumSets);
		for (int x = 0; x < initialNumSets; x++) {
			representatives.add(new ArrayList<>());
			makeSet(x);
		}
	}

	public void makeSet(int x) { // complete this method
		ArrayList<Integer> da = new ArrayList<>();
		da.add(x);
		representatives.set(x, da);
	}

	public ArrayList<Integer> find(int x) { // complete this method
		return representatives.get(x);
	}

	private void append(ArrayList<Integer> arg1, ArrayList<Integer> arg2) { // complete this method
		while (arg2.size() > 0) {
			int x = arg2.get(arg2.size() - 1);
			arg2.remove(arg2.size() - 1);
			representatives.set(x, arg1);
			arg1.add(x);
		}
	}

	public void doUnion(int x, int y) { // complete this method
		ArrayList<Integer> da_x = find(x);
		ArrayList<Integer> da_y = find(y);

		if (da_x.equals(da_y) == false) {
			if (da_x.size() >= da_y.size())
				append(da_x, da_y);
			else
				append(da_y, da_x);
		}
	}
}
