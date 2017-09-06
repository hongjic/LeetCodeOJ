package T379;

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class PhoneDirectory {

	private Queue<Integer> q;
	private Set<Integer> set;
	private int max;
	
	public PhoneDirectory(int maxNumbers) {
		max = maxNumbers;
		set = new HashSet<Integer>();
		q = new LinkedList<Integer>();
		for (int i= 0; i < maxNumbers; i ++) {
			set.add(i);
			q.offer(i);
		}
	}
	
	public int get() {
		if (q.size() == 0) return -1;
		int num = q.poll();
		set.remove(num);
		return num;
	}
	
	public boolean check(int number) {
		if (number >= max || number < 0) return false;
		return set.contains(number);
	}
	
	public void release(int number) {
		if (set.contains(number)) return;
		set.add(number);
		q.offer(number);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneDirectory pd = new PhoneDirectory(1);
		System.out.println(pd.check(0));
		System.out.println(pd.get());
		System.out.println(pd.check(0));
		System.out.println(pd.get());
	}

}
