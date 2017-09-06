package T373;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

public class Solution {

	// O(klogn) not the best.
	public List<int[]> ksmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<int[]>();
		if (k == 0 || nums1.length == 0 || nums2.length == 0) return res;
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>(){
			@Override
			public int compare(int[] p1, int[] p2) {
				return nums1[p1[0]] + nums2[p1[1]] - (nums1[p2[0]] + nums2[p2[1]]); 
			}
		});
		Set<String> set = new HashSet<String>();
		set.add("0,0");
		minHeap.offer(new int[]{0, 0});
		for (int i = 0; i < k; i ++) {
			if (minHeap.isEmpty()) break;
			int[] index = minHeap.poll();
			res.add(new int[]{nums1[index[0]], nums2[index[1]]});
			String next1 = String.format("%d,%d", index[0], index[1] + 1);
			String next2 = String.format("%d,%d", index[0] + 1, index[1]);
			if (index[1] + 1 < nums2.length && !set.contains(next1)) {
				minHeap.offer(new int[]{index[0], index[1] + 1}); set.add(next1);
			}
			if (index[0] + 1 < nums1.length && !set.contains(next2)) {
				minHeap.offer(new int[]{index[0] + 1, index[1]}); set.add(next2);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[]{1,2};
		int[] nums2 = new int[]{3};
		int k = 3;
		List<int[]> res = new Solution().ksmallestPairs(nums1, nums2, k);
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i)[0] + ", " + res.get(i)[1]);
	}

}
