package T281;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ZigzagIterator {
	
	private Queue<List<Integer>> lists;
	
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		lists = new LinkedList<List<Integer>>();
		if (v1.size() > 0) lists.add(v1);
		if (v2.size() > 0) lists.add(v2);
	}
	
	public int next() {
		List<Integer> list = lists.poll();
		int result = list.get(0);
		list.remove(0);
		if (list.size() > 0) 
			lists.add(list);
		return result;
	}
	
	public boolean hasNext() {
		return lists.size() > 0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> v1 = new ArrayList<Integer>();
		v1.add(1);
		v1.add(2);
		List<Integer> v2 = new ArrayList<Integer>();
		v2.add(3);
		v2.add(4);
		v2.add(5);
		v2.add(6);
		ZigzagIterator i = new ZigzagIterator(v1, v2);
		while (i.hasNext())
			System.out.println(i.next());
	}

}
