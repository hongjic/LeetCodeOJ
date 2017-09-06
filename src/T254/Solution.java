package T254;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	
	private int n;
	
	private void recursive(List<List<Integer>> result, int now, List<Integer> factors, int start) {
		if (now == 1) {
			result.add(new ArrayList<Integer>(factors));
			return;
		}
		for (int i = start; i <= now && i < n; i ++)
			if (now % i == 0) {
				factors.add(i);
				recursive(result, now / i, factors, i);
				factors.remove(factors.size() - 1);
			}
	}

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (n == 1) return result;
		this.n = n;
		recursive(result, n, new ArrayList<Integer>(), 2);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = new Solution().getFactors(8);
		for (int i = 0; i < result.size(); i ++) {
			for (int j = 0; j < result.get(i).size(); j ++)
				System.out.print(result.get(i).get(j) + ",");
			System.out.println();
		}
		
	}

}
