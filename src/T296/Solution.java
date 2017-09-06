package T296;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public int minTotalDistance(int[][] grid) {
		int rows = grid.length, cols = grid[0].length;
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		for (int i = 0; i < rows; i ++)
			for (int j = 0; j < cols; j ++)
				if (grid[i][j] == 1) {
					x.add(i); y.add(j);
				}
		return getDistance(x) + getDistance(y);
	}
	
	private int getDistance(List<Integer> list) {
		Collections.sort(list);
		int left = 0, right = list.size() - 1, sum = 0;
		while (left < right) sum += list.get(right --) - list.get(left ++);
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] {
				{1,0,0,0,1},
				{0,0,0,0,0},
				{0,0,1,0,0}
		};
		System.out.println(new Solution().minTotalDistance(grid));
	}

}
