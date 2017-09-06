package T351;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Solution {

	// {0,2}, {2,0}, {0,-2}, {-2,0}, {2,2}, {-2,-2}, {-2,2}, {2, -2}
	// 若位移属于上述情况之一， 则要计算当中节点是否已经visited
	
	private static final int[][] keys = {{0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
	private static Set<List<Integer>> cross;
	
	static {
		cross = new HashSet<List<Integer>>();
		cross.add(Arrays.asList(0,2));
		cross.add(Arrays.asList(2,0));
		cross.add(Arrays.asList(0,-2));
		cross.add(Arrays.asList(-2,0));
		cross.add(Arrays.asList(2,2));
		cross.add(Arrays.asList(-2,-2));
		cross.add(Arrays.asList(-2,2));
		cross.add(Arrays.asList(2,-2));
	}
	
	public int numberOfPatterns(int m, int n) {
		int sum = 0;
		List<List<Integer>> patterns = new ArrayList<List<Integer>>();
		for (int i = 1; i <= 9; i ++)
			patterns.add(Arrays.asList(i));
		if (m == 1) sum += 9;
		for (int i = 2; i <= n; i ++) {
			List<List<Integer>> pre = patterns;
			patterns = new ArrayList<List<Integer>>();
			for (int j = 0; j < pre.size(); j ++) {
				// for every possible pattern i - 1
				List<Integer> pattern = pre.get(j);
				Set<Integer> visited = new HashSet<Integer>(pattern);
				int lastKey = pattern.get(i - 2);
				for (int next = 1; next <= 9; next ++) 
					if (!visited.contains(next)) {
						int x2 = keys[next - 1][0];
						int y2 = keys[next - 1][1];
						int x1 = keys[lastKey - 1][0];
						int y1 = keys[lastKey - 1][1];
						if (cross.contains(Arrays.asList(x2-x1, y2-y1))) {
							if (!visited.contains((lastKey+ next) / 2)) continue;
						}
						List<Integer> newPattern = new ArrayList<Integer>(pattern);
						newPattern.add(next);
						patterns.add(newPattern);
					}
			}
			if (i >= m && i <= n)
				sum += patterns.size();
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().numberOfPatterns(2, 2));
	}

}
