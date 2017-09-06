package T170;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {

	private ArrayList<Integer> numbers;
	private Map<Integer, Integer> map;
	
	public TwoSum() {
		map = new HashMap<Integer, Integer>();
		numbers = new ArrayList<Integer>();
	}
	
	public void add(int number) {
		if (map.containsKey(number)) 
			map.put(number, map.get(number) + 1);
		else {
			map.put(number, 1);
			numbers.add(number);
		}
	}
	
	public boolean find(int value) {
		for (int i = 0; i < numbers.size(); i ++)
			if (map.containsKey(value - numbers.get(i)) && (value != 2*numbers.get(i) || map.get(numbers.get(i)) > 1))
				return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TwoSum twoSum = new TwoSum();
		 twoSum.add(0);
		 System.out.println(twoSum.find(0));
	}

}
