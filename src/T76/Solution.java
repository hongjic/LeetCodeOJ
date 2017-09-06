package T76;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		// 欠多少个
		int lent = t.length(),
			lens = s.length();
		for (int i = 0; i < lent; i ++)
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		int mapSize = map.size();
		int i = 0, j = 0, min = lens; // j is not included
		int minStart = 0, minEnd = lens;
		while (j < lens) {
			while (j < lens && !map.containsKey(s.charAt(j))) 
				j ++;
			if (j == lens) break;
			map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
			if (map.get(s.charAt(j)) == 0) mapSize --;
			j ++;
			while (i < j) {
				if (map.containsKey(s.charAt(i))) {
					if (map.get(s.charAt(i)) >= 0) break;
					map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
				}
				i ++;
			}
			if (mapSize == 0 && j - i < min) {
				min = j - i;
				minStart = i; minEnd = j;
			}
		}
		if (mapSize > 0) return "";
		return s.substring(minStart, minEnd);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "a";
		String t = "aa";
		System.out.println(sol.minWindow(s, t));
	}

}
