package T417;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Solution {
	
	private static final int[][] D = {{0,-1}, {-1,0}, {0,1}, {1,0}};

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> result = new ArrayList<int[]>();
		int rows = matrix.length;
		if (rows == 0) return result;
		int cols = matrix[0].length;
		boolean[][] atl = new boolean[rows][cols];
		boolean[][] pac = new boolean[rows][cols];
		Queue<int[]> atlQueue = new LinkedList<int[]>();
		Queue<int[]> pacQueue = new LinkedList<int[]>();
		
		// initialize atlantic and pacific
		for (int i = 0; i < cols; i ++) {
			atlQueue.offer(new int[] {rows - 1, i});
			atl[rows - 1][i] = true;
			pacQueue.offer(new int[] {0, i});
			pac[0][i] = true;
		}
		for (int i = 0; i < rows; i ++) {
			if (i != rows - 1) {
				atlQueue.offer(new int[] {i, cols - 1});
				atl[i][cols - 1] = true;
			}
			if (i != 0) {
				pacQueue.offer(new int[] {i, 0});
				pac[i][0] = true;
			}
		}
		
		// flow from low to high: atlantic
		while (!atlQueue.isEmpty()) {
			int[] cell = atlQueue.poll();
			for (int i = 0; i < 4; i ++) {
				int x = cell[0] + D[i][0];
				int y = cell[1] + D[i][1];
				if (x >= 0 && x < rows && y >= 0 && y < cols && !atl[x][y] && matrix[x][y] >= matrix[cell[0]][cell[1]]) {
					atlQueue.offer(new int[] {x, y});
					atl[x][y] = true;
				}
			}
		}
	
		// flow from low to high: pacific
		while (!pacQueue.isEmpty()) {
			int[] cell = pacQueue.poll();
			if (atl[cell[0]][cell[1]]) result.add(new int[] {cell[0], cell[1]});
			for (int i = 0; i < 4; i ++) {
				int x = cell[0] + D[i][0];
				int y = cell[1] + D[i][1];
				if (x >= 0 && x < rows && y >= 0 && y < cols && !pac[x][y] && matrix[x][y] >= matrix[cell[0]][cell[1]]) {
					pacQueue.offer(new int[] {x, y});
					pac[x][y] = true;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
		List<int[]> result = new Solution().pacificAtlantic(matrix);
		for (int i = 0; i < result.size(); i ++)
			System.out.println(result.get(i)[0] + " " + result.get(i)[1]);
	}

}
