package T290;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length()) return false;
		int len = words.length;
		Map<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < len; i ++) {
			if (!map.containsKey(pattern.charAt(i))) {
				if (map.values().contains(words[i])) return false;
				map.put(pattern.charAt(i), words[i]);
			}
			else
				if (!map.get(pattern.charAt(i)).equals(words[i])) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
	}

}
