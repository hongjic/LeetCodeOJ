package T356;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Solution {

	public boolean isReflected(int[][] points) {
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		Map<Integer, Integer> xmin = new HashMap<Integer, Integer>();
		Map<Integer, Integer> xmax = new HashMap<Integer, Integer>();
		for (int i = 0; i < points.length; i ++) {
			if (!map.containsKey(points[i][1])) {
				Set<Integer> set = new HashSet<Integer>();
				set.add(points[i][0]);
				xmin.put(points[i][1], points[i][0]);
				xmax.put(points[i][1], points[i][0]);
				map.put(points[i][1], set);
			}
			else {
				map.get(points[i][1]).add(points[i][0]);
				if (points[i][0] < xmin.get(points[i][1])) xmin.put(points[i][1], points[i][0]);
				if (points[i][0] > xmax.get(points[i][1])) xmax.put(points[i][1], points[i][0]);
			}
		}
		Double avg = null;
		for (int y: map.keySet()) {
			int pair = xmin.get(y) + xmax.get(y);
			// reflect ?
			Set<Integer> set = map.get(y);
			for (int x: set)
				if (!set.contains(pair - x)) return false;
			if (avg != null && (double) pair / 2 != avg) return false;
			else if (avg == null) avg = (double) pair / 2;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = new int[][] {
//				{-16, 1},{16,1},{16,1}
//				{1,1}, {-1,1}
				{1,1}, {-1,-1}
		};
		System.out.println(new Solution().isReflected(points));
	}

}
