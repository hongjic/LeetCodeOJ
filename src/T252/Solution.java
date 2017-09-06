package T252;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public static class Interval {
		int start, end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length <= 1)
			return true;
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		int len = intervals.length;
		for (int i = 0; i < len - 1; i ++)
			if (intervals[i].end > intervals[i + 1].start)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
//		Interval i1 = new Interval(0, 30);
//		Interval i2 = new Interval(5, 10);
//		Interval i3 = new Interval(15, 20);
		Interval i4 = new Interval(7, 10);
		Interval i5 = new Interval(2, 4);
		Interval[] intervals = new Interval[] {i4, i5};
		System.out.println(sol.canAttendMeetings(intervals));
	}

}
