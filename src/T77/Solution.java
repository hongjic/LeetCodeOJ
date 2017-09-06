package T77;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

	private List<List<Integer>> res;
	
	public List<List<Integer>> combine(int n, int k) {
		res = new ArrayList<List<Integer>>();
		helper(0, new LinkedList<Integer>(), n, k);
		return res;
	}
	
	private void helper(int index, LinkedList<Integer> comb, int n, int k) {
		if (index == k) {
			List<Integer> l = new ArrayList<Integer>();
			l.addAll(comb); res.add(l);
			return;
		}
		int min = 1;
		if (index > 0) min = comb.getLast() + 1;
		for (int cur = min; cur <= n - k + index + 1; cur ++) {
			comb.offerLast(cur);
			helper(index + 1, comb, n, k);
			comb.removeLast();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new Solution().combine(4, 2);
		for (int i = 0; i < res.size(); i ++) {
			for (int j = 0; j < res.get(i).size(); j ++)
				System.out.print(res.get(i).get(j));
			System.out.println();
		}
	}

}
