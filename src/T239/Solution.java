package T239;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {

	// O(nlogk)
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0) return new int[0];
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				if (i1 < i2) return 1;
				else if (i1 > i2) return -1;
				else return 0;
			}
		});
		for (int i = 0; i < k; i ++)
			heap.offer(nums[i]);
		int[] res = new int[nums.length + 1 - k];
		res[0] = heap.peek();
		for (int i = 1; i < nums.length + 1 - k; i ++) {
			heap.offer(nums[i + k - 1]);
			heap.remove(nums[i - 1]);
			res[i] = heap.peek();
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{};
		int k = 0;
		int[] res = new Solution().maxSlidingWindow(nums, k);
		for (int i = 0; i < res.length; i ++)
			System.out.print(res[i] + ", ");
	}

}
