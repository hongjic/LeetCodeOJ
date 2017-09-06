package T57_100;

import java.util.ArrayList;
import java.util.List;

public class T57 {
	
	private static class Interval {
		int start;
		int end;
		public Interval() {
			start = 0;
			end = 0;
		}
		public Interval(int s, int e) {
			start = s; end = e;
		}
		
		@Override
		public String toString() {
			return '[' + String.valueOf(start) + ", " + String.valueOf(end) + ']';
		}
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		int len = intervals.size();
		// binary search
		boolean only_once = false;
		Interval last = null, curr = null;
		int i = 0;
		while (i < len || !only_once) {
			curr = i < len ? intervals.get(i) : newInterval;
			if (!only_once && curr.start >= newInterval.start) {
				only_once = true;
				curr = newInterval;
				i--;
			}
			if (res.size() == 0 || curr.start > last.end) {
				res.add(curr);
				last = curr;
			}
			else {
				last.start = Math.min(last.start, curr.start);
				last.end = Math.max(last.end, curr.end);
			}
			i ++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T57 t57 = new T57();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		Interval newInterval = new Interval(15,20);
		List<Interval> res = t57.insert(intervals, newInterval);
		for (int i = 0; i < res.size(); i++) 
			System.out.print(res.get(i) + " ");
		System.out.println();
	}
}




//List<Interval> res = new ArrayList<Interval>();
//int len = intervals.size();
//// binary search
//boolean only_once = false;
//Interval last = null, curr = null;
//for (int i = 0; i < len; i ++) {
//	curr = intervals.get(i);
//	if (!only_once && curr.start >= newInterval.start) {
//		only_once = true;
//		curr = newInterval;
//		i--;
//	}
//	if (res.size() == 0 || curr.start > last.end) {
//		res.add(curr);
//		last = curr;
//	}
//	else {
//		last.start = Math.min(last.start, curr.start);
//		last.end = Math.max(last.end, curr.end);
//	}
//}
//if (!only_once) {
//	curr = newInterval;
//	if (res.size() == 0 || curr.start > last.end) {
//		res.add(curr);
//		last = curr;
//	}
//	else {
//		last.start = Math.min(last.start, curr.start);
//		last.end = Math.max(last.end, curr.end);
//	}
//}
//return res;