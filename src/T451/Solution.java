package T451;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

public class Solution {

	public String frequencySort(String s) {
		Character[] arr = new Character[s.length()];
		for (int i = 0; i < s.length(); i ++)
			arr[i] = s.charAt(i);
		Map<Character, Integer> count = new HashMap<Character, Integer>();
		for (Character c: arr)
			count.put(c, count.getOrDefault(c, 0) + 1);
		Arrays.sort(arr, new Comparator<Character>(){
			@Override
			public int compare(Character o1, Character o2) {
				int countD = count.get(o2) - count.get(o1);
				if (countD != 0) return countD;
				return o1.compareTo(o2);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i ++)
			sb.append(arr[i]);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().frequencySort("loveleetcode"));
	}

}
