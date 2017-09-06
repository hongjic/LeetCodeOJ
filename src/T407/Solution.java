package T407;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	private static final int[][] D = {{0,-1}, {-1,0}, {0,1}, {1,0}};
	
	public static class Cell {
		int row;
		int col;
		int height;
		Cell(int x, int y, int h) {
			row = x;
			col = y;
			height = h;
		}
	}
	
	public static class CellComparator implements Comparator<Cell> {
		@Override
		public int compare(Cell o1, Cell o2) {
			return o1.height - o2.height;
		}
	}
	
	public int trapRainWater(int[][] heightMap) {
		if (heightMap == null || heightMap.length == 0)
			return 0;
		int rows = heightMap.length;
		int cols = heightMap[0].length;
		
		PriorityQueue<Cell> cells = new PriorityQueue<Cell>(new CellComparator());
		boolean[][] visited = new boolean[rows][cols];
		
		// first, add border cells into the queue
		for (int i = 0; i < rows; i ++) {
			cells.offer(new Cell(i, 0, heightMap[i][0]));
			visited[i][0] = true;
			if (cols > 1) {
				cells.offer(new Cell(i, cols - 1, heightMap[i][cols - 1]));
				visited[i][cols - 1] = true;
			}
		}
		
		for (int i = 0; i < cols; i ++) {
			cells.offer(new Cell(0, i, heightMap[0][i]));
			visited[0][i] = true;
			if (rows > 0) {
				cells.offer(new Cell(rows - 1, i, heightMap[rows - 1][i]));
				visited[rows - 1][i] = true;
			}
		}
		
		// from the borders, pick the shortest cell visited and check its neighbors:
		// if neighbor is shorter, than fill it with water and update the height, then add the neighbor to queue
		// this process is to narrow the border.
		int result = 0;
		while (!cells.isEmpty()) {
			Cell cell = cells.poll();
			for (int i = 0; i < 4; i ++) {
				int x = cell.row + D[i][0];
				int y = cell.col + D[i][1];
				if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y]) {
					visited[x][y] = true;
					int add = Math.max(0, cell.height - heightMap[x][y]);
					result += add;
					cells.offer(new Cell(x, y, heightMap[x][y] + add));
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] height = new int[][] {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
		System.out.println(new Solution().trapRainWater(height));
	}

}
