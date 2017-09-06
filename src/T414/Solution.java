package T414;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

	public int thirdMax(int[] nums) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		int size = nums.length, k = 3;
		for (int i = 0; i < size; i ++) {
			if (!set.contains(nums[i])) {
				q.offer(nums[i]);
				set.add(nums[i]);
			}
			if (q.size() > k) set.remove(q.poll());
		}
		if (q.size() == 2) q.poll();
		return q.poll();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().thirdMax(new int[]{1,1,2}));
		
	}

}
