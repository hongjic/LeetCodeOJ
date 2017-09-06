package T499;

import java.util.HashMap;
import java.util.Map;

/*
 * It is not necessary to do the preprocess of move,
 * The time is reduces a lot by minDistance.
 */
public class Solution {

	private static char[] B = {'d', 'l', 'r', 'u'};
	private int min, rows, cols;
	private String minPath;
	
	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		rows = maze.length; cols = maze[0].length;
		min = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[rows][cols];
		visited[ball[0]][ball[1]] = true;
		int[][][][] move = new int[rows][cols][4][2];
		// left & right
		for (int i = 0; i < rows; i ++) {
			int j = 0, pre = -1;
			while (j < cols) {
				if (maze[i][j] == 1) pre = -1;
				else {
					if (pre == -1) pre = j;
					move[i][j][1][0] = i;
					move[i][j][1][1] = pre;
				}
				j ++;
			}
			j = cols - 1; pre = cols;
			while (j >= 0) {
				if (maze[i][j] == 1) pre = cols;
				else {
					if (pre == cols) pre = j;
					move[i][j][2][0] = i;
					move[i][j][2][1] = pre;
				}
				j --;
			}
		}
		// up and down
		for (int j = 0; j < cols; j ++) {
			int i = 0, pre = -1;
			while (i < rows) {
				if (maze[i][j] == 1) pre = -1;
				else {
					if (pre == -1) pre = i;
					move[i][j][3][0] = pre;
					move[i][j][3][1] = j;
				}
				i ++;
			}
			i = rows -1; pre = rows;
			while (i >= 0) {
				if (maze[i][j] == 1) pre = rows;
				else {
					if (pre == rows) pre = i;
					move[i][j][0][0] = pre;
					move[i][j][0][1] = j;
				}
				i --;
			}
		}
		Map<Integer, Integer> minDistance = new HashMap<Integer, Integer>();
		for (int i = 0; i < rows; i ++)
			for (int j = 0; j < cols; j ++)
				minDistance.put(i * cols + j, Integer.MAX_VALUE);
		helper(maze, visited, move, minDistance, ball, hole, 0, "");
		if (minPath == null) return "impossible";
		return minPath;
	}
	
	private void helper(int[][] maze, boolean[][] visited, int[][][][] move, Map<Integer, Integer> minDistance, int[] ball, int[] hole, int distance, String path) {
		if (distance > minDistance.get(ball[0] * cols + ball[1])) return;
		minDistance.put(ball[0] * cols + ball[1], distance);
		int[] cur = new int[2];
		for (int i = 0; i < 4; i ++) {
			cur[0] = ball[0]; cur[1] = ball[1];
			cur[0] = move[ball[0]][ball[1]][i][0]; cur[1] = move[ball[0]][ball[1]][i][1];
			int d = Math.abs(cur[0] - ball[0]) + Math.abs(cur[1] - ball[1]);
			if (hole[0] >= Math.min(ball[0], cur[0]) && hole[0] <= Math.max(ball[0], cur[0])
					&& hole[1] >= Math.min(ball[1], cur[1]) && hole[1] <= Math.max(ball[1], cur[1])) {
				d = Math.abs(hole[0] - ball[0]) + Math.abs(hole[1] - ball[1]);
				if (distance + d < min) {
					min = distance + d;
					minPath = path + B[i];
				}
			}
			if (!visited[cur[0]][cur[1]]) {
				visited[cur[0]][cur[1]] = true;
				helper(maze, visited, move, minDistance, cur, hole, distance + d, path + B[i]);
				visited[cur[0]][cur[1]] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] maze = new int[][] {
				{0,1,0,1,0,0,0,0,0,0,1},
				{0,1,0,1,1,1,0,1,1,0,0},
				{1,0,0,0,0,0,0,0,0,0,1},
				{0,0,0,1,1,1,0,1,0,0,1},
				{1,1,0,0,0,1,0,0,0,1,1},
				{0,1,0,0,0,0,0,1,0,1,0},
				{0,0,0,0,1,0,0,1,1,1,0}
		};
		int[] ball = new int[] {0,4};
		int[] hole = new int[] {5,0};
		System.out.println(new Solution().findShortestWay(maze, ball, hole));
	}

}
