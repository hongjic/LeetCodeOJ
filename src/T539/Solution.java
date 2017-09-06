package T539;

import java.util.List;
import java.util.Collections;
import java.util.Arrays;

public class Solution {

	public int findMinDifference(List<String> timePoints) {
		Collections.sort(timePoints);
		int min = diff(timePoints.get(timePoints.size() - 1), "24:00") + diff("00:00", timePoints.get(0));
		for (int i = 1; i < timePoints.size(); i ++) {
			min = Math.min(min, diff(timePoints.get(i - 1), timePoints.get(i)));
		}
		return min;
	}
	
	// t2 > t1
	private int diff(String t1, String t2) {
		String h1 = t1.substring(0, 2), h2 = t2.substring(0, 2);
		String m1 = t1.substring(3, 5), m2 = t2.substring(3, 5);
		if (h1.equals(h2)) return Integer.valueOf(m2) - Integer.valueOf(m1);
		return Integer.valueOf(m2) + 60 - Integer.valueOf(m1) + (Integer.valueOf(h2) - Integer.valueOf(h1) - 1) * 60;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> timePoints = Arrays.asList("23:59", "15:55", "12:00", "16:33", "10:59", "09:56", "07:23", "01:50");
		int res = new Solution().findMinDifference(timePoints);
		System.out.println(res);
	}

}
