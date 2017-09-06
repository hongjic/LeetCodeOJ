package T205;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Solution {

	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null)
			return true;
		if (s.length() != t.length())
			return false;
		if (s.length() == 0)
			return true;
		int len = s.length();
		Map<Character, Character> map = new HashMap<Character, Character>();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < len; i ++) {
			if (map.containsKey(s.charAt(i))) {
				if (map.get(s.charAt(i)) != t.charAt(i))
					return false;
			}
			else {
				if (set.contains(t.charAt(i))) 
					return false;
				map.put(s.charAt(i), t.charAt(i));
				set.add(t.charAt(i));
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.remove(0);
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isIsomorphic("ad", "ad"));
	}

}
