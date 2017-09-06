package T387;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c: s.toCharArray()) 
			map.put(c, map.getOrDefault(c, 0) + 1);
		int i = 0;
		while (i < s.length() && map.get(s.charAt(i)) != 1) i ++;
		if (i == s.length()) return -1;
		return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().firstUniqChar("loveleetcode"));
	}

}
