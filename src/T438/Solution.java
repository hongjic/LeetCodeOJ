package T438;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {
	
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<Integer>();
		int lenp = p.length(), lens = s.length();
		Map<Character, Integer> pattern = new HashMap<Character, Integer>();
		for (char c: p.toCharArray())
			pattern.put(c, pattern.getOrDefault(c, 0) + 1);
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i <= lens - lenp; i ++) {
			if (i == 0) {
				for (int j = i; j <= i + lenp - 1; j ++)
					map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
			}
			else {
				int count = map.get(s.charAt(i - 1));
				if (count == 1) map.remove(s.charAt(i - 1));
				else map.put(s.charAt(i - 1), count - 1);
				map.put(s.charAt(i + lenp - 1), map.getOrDefault(s.charAt(i + lenp - 1), 0) + 1);
			}
			boolean flag = true;
			if (pattern.size() != map.size()) flag = false;  
			for (char c: pattern.keySet())
				if (!map.containsKey(c) || pattern.get(c).intValue() != map.get(c).intValue()) {
					flag = false;
					break;
				}
			if (flag) res.add(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		List<Integer> indexes = new Solution().findAnagrams("cbaebabacd", "abc");
		for (int i = 0; i < indexes.size(); i ++)
			System.out.print(indexes.get(i) + ", ");
	}

}
