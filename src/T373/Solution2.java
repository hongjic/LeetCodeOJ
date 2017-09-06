package T373;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution2 {

	// O(klogk).
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<int[]>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
		int len1 = nums1.length, len2 = nums2.length;
	
		// initialize minHeap
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				return nums1[p1[0]] + nums2[p1[1]] - (nums1[p2[0]] + nums2[p2[1]]); 
			}
		});
		for (int i = 0; i < len1; i ++)
			minHeap.offer(new int[]{i, 0});
		// generate sum list
		// compare to Solution1, every time poll out a pair, only one new pair should be added, and there is no duplicate.
		// so don't need extra hash set.
		for (int i = 0; i < k; i ++) {
			if (minHeap.isEmpty()) break;
			int[] index = minHeap.poll();
			res.add(new int[]{nums1[index[0]], nums2[index[1]]});
			if (index[1] < len2 - 1) {
				index[1] += 1;
				minHeap.offer(index);				
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[]{1,2};
		int[] nums2 = new int[]{3};
		int k = 3;
		List<int[]> res = new Solution2().kSmallestPairs(nums1, nums2, k);
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i)[0] + ", " + res.get(i)[1]);
	}

}
