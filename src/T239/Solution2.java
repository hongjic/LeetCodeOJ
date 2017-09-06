package T239;

import java.util.Deque;
import java.util.ArrayDeque;

public class Solution2 {

	public int[] maxSlidingWindow(int[] a, int k) {
		if (a == null || k <= 0) return new int[0];
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		Deque<Integer> q = new ArrayDeque<Integer>();
		for (int i = 0; i < a.length; i ++) {
			// poll the numbers that are not in the sliding window.
			while (!q.isEmpty() && q.peek() < i - k + 1)
				q.poll();
			// poll the numbers 
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) 
				q.pollLast();
			q.offer(i);
			if (i >= k - 1) {
				r[ri ++] = a[q.peek()];
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] res = new Solution2().maxSlidingWindow(nums, k);
		for (int i = 0; i < res.length; i ++)
			System.out.println(res[i] + ", ");
	}
}
