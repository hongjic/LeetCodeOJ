package T378;

import java.util.PriorityQueue;

class Point implements Comparable<Point>{
	int x, y, val;
	Point(int xx, int yy, int v) {
		x = xx; y = yy; val = v;
	}
	
	@Override
	public int compareTo(Point other) {
		return val - other.val;
	}
}

public class Solution {

	// heap solution
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		for (int i = 0; i < n; i ++) pq.offer(new Point(0, i, matrix[0][i]));
		for (int i = 0; i < k - 1; i ++) {
			Point p = pq.poll();
			if (p.x < n - 1) 
				pq.offer(new Point(p.x + 1, p.y, matrix[p.x + 1][p.y]));
		}
		return pq.poll().val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1, 5, 9},
				{10, 11, 13},
				{12, 13, 15}
		};
		System.out.println(new Solution().kthSmallest(matrix, 8));
	}

}
