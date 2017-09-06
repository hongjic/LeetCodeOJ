package T447;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution {

	public int numberOfBoomerangs(int[][] points) {
		int sum = 0;
		Map<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
		for (int i = 0; i < points.length; i ++) {
			map.clear();
			for (int j = 0; j < points.length; j ++) 
				if (i != j) {
					int d = getDistance(points[i], points[j]);
					if (!map.containsKey(d)) map.put(d, new ArrayList<int[]>());
					map.get(d).add(points[j]);
				}
			for (int d: map.keySet()) {
				int n = map.get(d).size();
				sum += n * (n - 1);
			}
		}
		return sum;
	}
	
	private int getDistance(int[] point1, int[] point2) {
		return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = new int[][] {{0,0}, {1,0}, {-1,0}, {0,1}, {0,-1}};
		System.out.println(new Solution().numberOfBoomerangs(points));
	}

}
