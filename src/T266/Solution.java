package T266;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public boolean canPermutePalindrome(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c: s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		int sum = 0;
		for (char c: map.keySet())
			if ((map.get(c) & 1) == 1) sum ++;
		if (sum > 1) return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().canPermutePalindrome("aab"));
	}

}
