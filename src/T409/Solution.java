package T409;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c: s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		int sum = 0;
		boolean flag = false;
		for (char c: map.keySet()) {
			if ((map.get(c) & 1) == 1) {
				if (!flag) {
					sum += map.get(c);
					flag = true;
				}
				else sum += map.get(c) - 1;
			}
			else sum += map.get(c);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().longestPalindrome("abccccdd"));
	}

}
