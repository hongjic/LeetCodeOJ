package T101_end;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class T380 {

	public static class RandomizedSet {
		
		private List<Integer> list;
		private Map<Integer, Integer> position;
		private static Random random = new Random();
		
		/* initialzie */
		public RandomizedSet() {
			list = new ArrayList<Integer>();
			position = new HashMap<Integer, Integer>();
		}
		
		/* Inserts a value to the set. Returns true if the set did not already contain the specified element. */
		public boolean insert(int val) {
			if (position.containsKey(val))
				return false;
			list.add(val);
			position.put(val, list.size() - 1);
			return true;
		}
		
		/* Removes a value from the set. Returns true if the set contained the specified element. */
		public boolean remove(int val) {
			if (!position.containsKey(val))
				return false;
			int p = position.get(val);
			int lastVal = list.get(list.size() - 1);
			list.set(p, lastVal);
			list.remove(list.size() - 1);
			position.put(lastVal, p);
			position.remove(val);
			return true;
		}
		
		/* Get a random element from the set. */
		public int getRandom() {
			return list.get(random.nextInt(list.size()));
		}
		
	}
	
	
	public static void main(String[] args) {
		RandomizedSet set = new RandomizedSet();
		set.insert(0);
		set.remove(0);
		set.insert(-1);
		set.remove(0);
		System.out.println(set.getRandom());
		System.out.println(set.getRandom());
		System.out.println(set.getRandom());
		System.out.println(set.getRandom());
		System.out.println(set.getRandom());
		System.out.println(set.getRandom());
		System.out.println(set.getRandom());
		
		
	}

}
