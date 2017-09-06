package T542;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	private static final int[][] D = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

	public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
		int rows = matrix.size();
		int cols = matrix.get(0).size();
		boolean solved[][] = new boolean[rows][cols];
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < rows; i ++) {
			List<Integer> r = new ArrayList<Integer>();
			for (int j = 0; j < cols; j ++) r.add(0);
			res.add(r);
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < rows; i ++)
			for (int j = 0; j < cols; j ++)
				if (matrix.get(i).get(j) == 0) {
					q.offer(new int[]{i, j, 0});
					solved[i][j] = true;
				}
		while (!q.isEmpty()) {
			int[] root = q.poll();
			res.get(root[0]).set(root[1], root[2]);
			for (int i = 0; i < 4; i ++)
				if (root[0] + D[i][0] < rows && root[0] + D[i][0] >= 0 && root[1] + D[i][1] >= 0 && root[1] + D[i][1] < cols && 
					!solved[root[0] + D[i][0]][root[1] + D[i][1]]) {
					q.offer(new int[]{root[0] + D[i][0], root[1] + D[i][1], root[2] + 1});
					solved[root[0] + D[i][0]][root[1] + D[i][1]] = true;
				}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
//		matrix.add(Arrays.asList(0,0,0));
//		matrix.add(Arrays.asList(0,1,0));
//		matrix.add(Arrays.asList(1,1,1));
		matrix.add(Arrays.asList(1));
		List<List<Integer>> res = new Solution().updateMatrix(matrix);
	
		for (int i = 0; i < res.size(); i ++) {
			for (int j = 0; j < res.get(i).size(); j ++)
				System.out.print(res.get(i).get(j) + " ");
			System.out.println();
		}
	}

}
