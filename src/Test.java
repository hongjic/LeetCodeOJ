import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Thing {
	public Integer a;
	public Integer b;
	public Thing(int a,int b){
		this.a = a;
		this.b = b;
	}
}

interface Command {
	public int getValue();

}

abstract class ACommand {
	public abstract int getValue();
}

class SubCommand extends ACommand implements Command{
	
	@Override
	public int getValue() {
		return 5;
	}
}

class Sub2Command extends ACommand implements Command {
	@Override
	public int getValue() {
		return 4;
	}
}

abstract class A {
	public void print() {
		System.out.println("AaaA");
	}
}

class B extends  A {
	public void print() {
		System.out.println("BBB");
	}
}

public class Test {
	
	private static void cal(Integer i, Integer j) {
		i ++;
		j++;
	}
	
	private static void stackOverFlow(int i) {
		System.out.println(i);
		int[] a = {2,3,4,5,6,7,8};
		stackOverFlow(i + 1);
	}
	
	public static class StringComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Command command1 = new SubCommand();
//		ACommand command2 = new SubCommand();
//		command2 = new Sub2Command();
//		System.out.println(command1.getClass());
//		System.out.println(command2.getClass());
//		String st = "aaa";
//		int n = 9;
//		System.out.println(String.format("%"+ String.valueOf(n)+"s", st));
		
//		Integer i = 5;
//		Integer j = 6;
//		cal(i, j);
//		System.out.println(i);
//		System.out.println(j);
//		stackOverFlow(0);
//		PriorityQueue<String> queue = new PriorityQueue<String>(3, new StringComparator());
//		queue.offer("aaa");
//		queue.offer("bbb");
//		queue.offer("ccccc");
//		queue.offer("ddddddd");
//		queue.offer("ee");
//		queue.offer("ffffffff");
//		queue.offer("g");
//		while (!queue.isEmpty()) 
//			System.out.println(queue.poll());
		
		
//		Integer a = 1;
//		Integer b = 2;
//		Integer c = 1;
//		Integer d = 129;
//		Integer e = 129;
//		System.out.println(a == c);
//		System.out.println(d == e);
		
//		Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
//		ArrayList<Integer> key1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
//		ArrayList<Integer> key2 = new ArrayList<Integer>(Arrays.asList(2,3,4,5,6));
//		ArrayList<Integer> key3 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
//		map.put(key1, 1);
//		map.put(key2, 2);
//		map.put(key3, 3);
//		System.out.println(map.get(key1));
//		System.out.println(map.get(key3));
		A a = new B();
		a.print();
	}
	
	
	public class AbstractTest {
		int m;
	}

}
