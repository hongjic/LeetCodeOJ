package T84;

import java.util.PriorityQueue;

// time Complexity O(nlogn)
// don't need to use priority queue, stack is enough because the order is guaranteed.
public class Solution {

	private static class Bar implements Comparable<Bar>{
		int height, index;
		public Bar(int h, int i) {
			height = h; index = i;
		}
		@Override
		public int compareTo(Bar o) {
			return ((Bar)o).height - height;
		}
	}
	
	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0) return 0;
		int[] area = new int[heights.length];
		PriorityQueue<Bar> bars = new PriorityQueue<Bar>();
		// left to right
		bars.add(new Bar(heights[0], 0));
		for (int i = 1; i < heights.length; i ++) {
			while (!bars.isEmpty() && bars.peek().height > heights[i]) {
				Bar top = bars.poll();
				area[top.index] += top.height * (i - top.index);
			}
			bars.offer(new Bar(heights[i], i));
		}
		while (!bars.isEmpty()) {
			Bar top = bars.poll();
			area[top.index] += top.height * (heights.length - top.index); 
		}
		// right to left
		bars.add(new Bar(heights[heights.length - 1], heights.length - 1));
		for (int i = heights.length - 2; i >= 0; i --) {
			while (!bars.isEmpty() && bars.peek().height > heights[i]) {
				Bar top = bars.poll();
				area[top.index] += top.height * (top.index - i - 1); 
			}
			bars.offer(new Bar(heights[i], i));
		}
		while (!bars.isEmpty()) {
			Bar top = bars.poll();
			area[top.index] += top.height * top.index;
		}
		int max = 0;
		for (int i = 0; i < heights.length; i ++)
			max = Math.max(max, area[i]);
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = new int[] {2,1,5,6,3,4,7,8,2,9,3,6,7,8,2,4,3,6,7,7,7};
		System.out.println(new Solution().largestRectangleArea(heights));
	}

}
