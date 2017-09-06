package T101_end;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T253 {

	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static class StartComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval a, Interval b) {
			if (a.start < b.start)
				return -1;
			else if (a.start > b.start)
				return 1;
			else return 0;
		}
	}
	
	public static class EndComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval a, Interval b) {
			if (a.end < b.end)
				return -1;
			else if (a.end > b.end)
				return 1;
			else return 0;
		}
	}
	
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) return 0;
		Arrays.sort(intervals, new StartComparator());
		PriorityQueue<Interval> room = new PriorityQueue<Interval>(intervals.length, new EndComparator());
		room.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i ++) {
			Interval interval = room.poll();
			if (interval.end <= intervals[i].start) 
				interval.end = intervals[i].end;
			else
				room.offer(intervals[i]);
			room.offer(interval);
		}
		return room.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T253 t253 = new T253();
		Interval[] intervals = {new Interval(2, 15), new Interval(36, 45), new Interval(9, 29), new Interval(16, 23), new Interval(4, 9)};
		System.out.println(t253.minMeetingRooms(intervals));
	}

}
