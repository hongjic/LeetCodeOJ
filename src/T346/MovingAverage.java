package T346;

import java.util.Queue;
import java.util.LinkedList;

public class MovingAverage {

	private int sum, size;
	private Queue<Integer> queue;
	
	public MovingAverage(int size) {
		sum = 0;
		queue = new LinkedList<Integer>();
		this.size = size;
	}
	
	public double next(int val) {
		queue.offer(val);
		sum += val;
		if (queue.size() > size)
			sum -= queue.poll();
		return (double)sum / queue.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingAverage ma = new MovingAverage(3);
		System.out.println(ma.next(1));
		System.out.println(ma.next(10));
		System.out.println(ma.next(3));
		System.out.println(ma.next(5));
	}

}
