package T340;

import java.util.Map;
import java.util.HashMap;

public class Solution2 {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0 || k == 0)
			return 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int distinct = 0, i = 0, max = 0;
		for (int j = 0; j < s.length(); j ++) {
			char end = s.charAt(j);
			if (!map.containsKey(end)) distinct ++;
			map.put(end, map.getOrDefault(end, 0) + 1);
			while (distinct > k) {
				char head = s.charAt(i ++);
				map.put(head, map.get(head) - 1);
				if (map.get(head) == 0) {
					distinct --;
					map.remove(head);
				}
			}
			max = Math.max(max, j - i + 1);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().lengthOfLongestSubstringKDistinct("eceba", 3));
	}

}
