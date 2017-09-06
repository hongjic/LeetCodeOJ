package T159;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int max = 0;
		int i = 0, j = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while (j < s.length()) {
			while (j < s.length() && map.size() <= 2) {
				map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
				j ++;
			}
			if (map.size() <= 2) max = Math.max(max, j - i);
			else max = Math.max(max, j - i - 1);
			while (map.size() > 2) {
				int num = map.get(s.charAt(i));
				if (num == 1) map.remove(s.charAt(i));
				else map.put(s.charAt(i), num - 1);
				i ++;
			}
		}
		return max;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("eceba"));
	}
}
