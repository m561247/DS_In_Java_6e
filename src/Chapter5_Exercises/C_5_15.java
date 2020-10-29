package Chapter5_Exercises;

import java.util.ArrayList;

public class C_5_15 {
	public static <E> ArrayList<ArrayList<E>> subSets(ArrayList<E> set){
		ArrayList<ArrayList<E>> allSubsets = new ArrayList<>();
		subsetsHelper(allSubsets, set, 0);
		return allSubsets;
	}
	public static <E> void subsetsHelper(ArrayList<ArrayList<E>> pSet, ArrayList<E> set, int n) {
		if (pSet.size()	== 0) {
			pSet.add(0, new ArrayList<E>());
		}
		if (n == set.size()) {
			return ;
		}
		int pSize = pSet.size();
		for (int i = 0; i < pSize; i++) {
			ArrayList<E> temp = (ArrayList<E>) pSet.get(i).clone();
			temp.add(temp.size(), set.get(n));
			pSet.add(pSet.size(), temp);
		}
		subsetsHelper(pSet, set, n + 1);
	}
}
