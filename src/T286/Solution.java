package T286;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
	
	// multi point bfs
	private static final int[][] D = {{0,-1}, {-1,0}, {0,1}, {1,0}};
	
	public void wallsAndGates(int[][] rooms) {
		int rows = rooms.length;
		if (rows == 0) return;
		int cols = rooms[0].length;
		Queue<int[]> points = new LinkedList<int[]>();
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i ++)
			for (int j = 0; j < cols; j ++)
				if (rooms[i][j] == 0) {
					points.add(new int[] {i, j, 0});
					visited[i][j] = true;
				}
		
		// multi bfs
		while (!points.isEmpty()) {
			int[] p = points.poll();
			rooms[p[0]][p[1]] = p[2];
			for (int i = 0; i < 4; i ++) {
				int x = p[0] + D[i][0];
				int y = p[1] + D[i][1];
				if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && rooms[x][y] != -1) {
					points.offer(new int[]{x, y, p[2] + 1});
					visited[x][y] = true;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
		int[][] rooms = new int[][] {{2147483647,-1,0,2147483647}, {2147483647,2147483647,2147483647,-1}, {2147483647,-1,2147483647,-1}, {0,-1,2147483647,2147483647}};
		new Solution().wallsAndGates(rooms);
		for (int i = 0; i < rooms.length; i ++) {
			for (int j = 0; j < rooms[i].length; j ++)
				System.out.print(rooms[i][j] + " ");
			System.out.println();
		}
	}

}
