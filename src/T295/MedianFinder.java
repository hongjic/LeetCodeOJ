package T295;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	
	private PriorityQueue<Integer> left, right;
	
	public MedianFinder() {
		left = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap
		right = new PriorityQueue<Integer>(); // min heap
	}

	public void addNum(int num) {
		left.add(num);
		right.add(left.poll());
		if (left.size() + 1 < right.size()) {
			left.add(right.poll());
		}
	}
	
	public double findMedian() {
		if (left.size() == right.size()) 
			return (double)(left.peek() + right.peek()) / 2;
		return right.peek();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFinder finder = new MedianFinder();
		finder.addNum(1);
		System.out.println(finder.findMedian());
		finder.addNum(2);
		System.out.println(finder.findMedian());
		finder.addNum(5);
		System.out.println(finder.findMedian());
		finder.addNum(3);
		System.out.println(finder.findMedian());
	}

}
