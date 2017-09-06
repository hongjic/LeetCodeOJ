package T101_end;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class T381 {

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
		
		public int size() {
			return list.size();
		}
		
	}
	
	
	public static class RandomizedCollection {
		
		private static Random random = new Random();
		private List<Integer> list;
		private Map<Integer, RandomizedSet> positions;
		
		public RandomizedCollection() {
			list = new ArrayList<Integer>();
			positions = new HashMap<Integer, RandomizedSet>();
		}
		
		public boolean insert(int val) {
			if (positions.containsKey(val)) {
				list.add(val);
				RandomizedSet pVal = positions.get(val);
				pVal.insert(list.size() - 1);
				return false;
			}
			else {
				RandomizedSet pVal = new RandomizedSet();
				list.add(val);
				pVal.insert(list.size() - 1);
				positions.put(val, pVal);
				return true;
			}
		}
		
		public boolean remove(int val) {
			if (!positions.containsKey(val))
				return false;
			if (val == list.get(list.size() - 1)) {
				RandomizedSet s = positions.get(val);
				s.remove(list.size() - 1);
				if (s.size() == 0)
					positions.remove(val);
				list.remove(list.size() - 1);
				return true;
			}
			
			RandomizedSet pVal = positions.get(val);
			int pDel = pVal.getRandom();
			//list中最后一个数字对应的地址变换
			int lastVal = list.get(list.size() - 1);
			RandomizedSet pLast = positions.get(lastVal);
			pLast.remove(list.size() - 1);
			pLast.insert(pDel);			
			//val对应的地址删掉一个
			pVal.remove(pDel);
			if (pVal.size() == 0)
				positions.remove(val);
			//list中val和最后一个交换并长度-1
			list.set(pDel, list.get(list.size() - 1));
			list.remove(list.size() - 1);
			return true;
		}
		
		public int getRandom() {
			return list.get(random.nextInt(list.size()));
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedCollection set = new RandomizedCollection();
		set.insert(0);
		set.insert(1);
		set.insert(2);
		set.insert(3);
		set.insert(3);
		set.remove(2);
		set.remove(3);
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
