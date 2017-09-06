package T383;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c: ransomNote.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (char c: magazine.toCharArray()) {
			if (map.containsKey(c)) {
				int times = map.get(c);
				if (times == 1) map.remove(c);
				else map.put(c, times - 1);
			}
			if (map.isEmpty()) return true;
		}
		return map.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().canConstruct("aa", "aab"));
	}

}
