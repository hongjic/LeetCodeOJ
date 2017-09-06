package T216;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		recursion(0, 0, new int[k], res, n ,k);
		return res;
	}
	
	private void recursion(int dep, int sum, int[] cur, List<List<Integer>> res, int n, int k) {
		if (dep == k) {
			List<Integer> l = new ArrayList<Integer>();
			for (int num: cur) l.add(num);
			res.add(l);
		}
		int min = 1;
		if (dep > 0) min = cur[dep - 1] + 1;
		min = Math.max(min, n - sum - 9 * (k - dep  -1));
		for (int i = min; i <= Math.min(n - sum, 9); i ++) {
			cur[dep] = i;
			recursion(dep + 1, sum + i, cur, res, n, k);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new Solution().combinationSum3(4, 24);
		for (int i = 0; i < res.size(); i ++) {
			for (int j = 0; j < res.get(i).size(); j ++)
				System.out.print(res.get(i).get(j) + ", ");
			System.out.println();
		}
	}

}
