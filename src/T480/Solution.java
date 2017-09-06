package T480;

import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {

	
	// Weekly Contest 14: Sliding Window Median
	public double[] medianSlidingWindow(int[] nums, int k) {
		PriorityQueue<Integer> left = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2) return 1;
				else if (o1 > o2) return -1;
				return 0;
			}
		});
		PriorityQueue<Integer> right = new PriorityQueue<Integer>();
		int len = nums.length;
		double[] res = new double[len + 1 - k];
		
		// initialize left and right with the first window.
		for (int i = 0; i < k; i ++)
			addElement(left, right, nums[i]);
		res[0] = getMedian(left, right, k);
		// calculate other medians
		for (int i = 1; i <= len - k; i ++) {
			addElement(left, right, nums[i + k - 1]);
			removeElement(left, right, nums[i - 1]);
			res[i] = getMedian(left, right, k);
		}
		return res;
	}
	
	private double getMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int len) {
		if ((len & 1) == 1)
			return (double)left.peek();
		else return ((double)left.peek() + right.peek()) / 2;
	}
	
	private void addElement(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int ele) {
		left.offer(ele);
		right.offer(left.poll());
		if (right.size() > left.size()) 
			left.offer(right.poll());
	}
	
	private void removeElement(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int ele) {
		if (ele <= left.peek()) {
			left.remove(ele);
			if (left.size() < right.size()) left.offer(right.poll());
		}
		else {
			right.remove(ele);
			if (right.size() < left.size() - 1) right.offer(left.poll());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {-2147483648, -2147483648, 2147483647, -2147483648, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, -2147483648, -2147483648};
		double[] res= new Solution().medianSlidingWindow(nums, 3);
		for (int i = 0; i < res.length; i ++)
			System.out.print(res[i] + ", ");
	}

}
