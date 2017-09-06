package T12_56;
import java.util.ArrayList;
import java.util.List;

class Interval {
	int start;
	int end;
	
	public Interval() {
		start = 0; 
		end = 0;
	}
	
	public Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
	public String toString() {
		return '[' + String.valueOf(start) + ", " + String.valueOf(end) + "]";
	}
}

public class T56 {
	
	private Integer compareTo(Interval a, Interval b) {
		if (a == null || b == null) return null; 
		if (a.start > b.start) return 1;
		if (a.start < b.start) return -1;
		if (a.end < b.end) return 1;
		if (a.end > b.end) return -1;
		return 0;
	}
	
	private void sort(List<Interval> intervals, int s, int t) {
		if (s>=t) return;
		Interval tmp = intervals.get(s);
		int i = s, j = t;
		while (i < j) {
			while (i < j && compareTo(intervals.get(j), tmp) >= 0)
				j --;
			if (i < j) intervals.set(i ++, intervals.get(j));
			while (i < j && compareTo(intervals.get(i), tmp) <= 0)
				i ++;
			if (i < j) intervals.set(j --, intervals.get(i));
		}
		intervals.set(i, tmp);
		sort(intervals, s, i - 1);
		sort(intervals, i + 1, t);
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		int len = intervals.size();
		if (len == 0) return res;
		sort(intervals, 0, len - 1);
		//  排序的作用是： 每次只需要将心的interval和结果res中的最后一个进行比较，如果可以合并则合并，
		//  不可能存在“可以和除res中最后一个之外的已合并结果继续合并“的可能
		Interval last = null;
		for (int i = 0; i < len; i++) {
			Interval curr = intervals.get(i);
			if (res.size() == 0 || curr.start > last.end) { 
				res.add(curr);
				last = res.get(res.size() - 1);
			}
			else {
				last.start = Math.min(last.start, curr.start);
				last.end = Math.max(last.end, curr.end);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T56 t56 = new T56();
		List<Interval> list = new ArrayList<Interval>();
		Interval i1 = new Interval(1, 4);
		Interval i2 = new Interval(5, 6);
//		Interval i3 = new Interval(7, 10);
//		Interval i4 = new Interval(15, 18);
		list.add(i1);
		list.add(i2);
//		list.add(i3);
//		list.add(i4);
		List<Interval> res = t56.merge(list);
		for (int i=0; i < res.size(); i++)
			System.out.print(res.get(i).toString() + " ");
	}

}



//public class Solution {
//    public List<Interval> merge(List<Interval> intervals) {
//        if(intervals.size()<=1) 
//            return intervals;
//
//        List<Interval> afterMergeList = new ArrayList<>();
//
//        Collections.sort(intervals, new Comparator<Interval>(){
//           public int compare(Interval a, Interval b){
//               return Integer.compare(a.start, b.start);
//           }
//        });
//        int start=0, end=0;
//        for(int i=0;i<intervals.size();++i){
//            Interval cur = intervals.get(i);
//            if(i==0){
//                start=cur.start;
//                end=cur.end;
//            }else{
//                if(cur.start>end){
//                    afterMergeList.add(new Interval(start, end));
//                    start = cur.start;
//                    end = cur.end;
//                }else{
//                    end=Math.max(end, cur.end);
//                }
//            }       
//        }
//        afterMergeList.add(new Interval(start, end));
//        return afterMergeList;
//    }
//}