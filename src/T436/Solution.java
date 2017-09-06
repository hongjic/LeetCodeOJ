package T436;

import java.util.TreeMap;

public class Solution {

	// use TreeMap to build a BST with index attached.
	public int[] findRightInterval(Interval[] intervals) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(); 
		int len = intervals.length;
		for (int i = 0; i < len; i ++)
			map.put(intervals[i].start, i);
		int[] res = new int[len];
		for (int i = 0; i < len; i ++) {
			Integer right = map.ceilingKey(intervals[i].end);
			if (right == null) res[i] = -1;
			else res[i] = map.get(right);
			res[i] = (right == null) ? -1 : map.get(right);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval[] intervals = {new Interval(1, 4), new Interval(2, 3), new Interval(3, 4)};
		int[] res = new Solution().findRightInterval(intervals);
		for (int i = 0; i < res.length; i ++)
			System.out.println(res[i]);
	}

}
