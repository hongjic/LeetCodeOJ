package T225;

import java.util.Queue;
import java.util.LinkedList;

public class MyStack {

	private Queue<Integer> queue;
	
	public MyStack() {
		queue = new LinkedList<Integer>();
	}
	
	public void push(int x) {
		queue.offer(x);
	}
	
	public void pop() {
		int times = queue.size();
		for (int i = 0; i < times - 1; i ++)
			queue.offer(queue.poll());
		queue.poll();
	}
	
	public int top() {
		int times = queue.size();
		for (int i = 0; i < times - 1; i ++)
			queue.offer(queue.poll());
		int top = queue.peek();
		queue.offer(queue.poll());
		return top;
	}
	
	public boolean empty() {
		return queue.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
