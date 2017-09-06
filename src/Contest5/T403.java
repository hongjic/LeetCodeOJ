package Contest5;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class T403 {
	

	public boolean canCross(int[] stones) {
		List<Set<Integer>> lj = new ArrayList<Set<Integer>>();
		if (stones[1] != 1) return false;
		int len = stones.length;
		for (int i = 0; i < len; ++ i) 
			lj.add(new HashSet<Integer>());
		lj.get(1).add(1);
		for (int i = 2; i < len; ++ i) {
			for (int j = 1; j < i; ++ j) {
				int need = stones[i] - stones[j];
				if (need > j + 1) continue;
				for (Integer steps : lj.get(j)) 
					if (need <= steps + 1 && need >= steps - 1) {
						lj.get(i).add(need);
						break;
					}
			}
		}
		return lj.get(len - 1).size() > 0 ? true : false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T403 t403 = new T403();
		//int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
		int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
		System.out.println(t403.canCross(stones));
	}

}
