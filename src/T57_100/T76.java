package T57_100;

import java.util.HashMap;
import java.util.Map;

public class T76 {

	private boolean subset(Map<Character, Integer> subset, Map<Character, Integer> set) {
		for (Character c: subset.keySet())
			if (!set.containsKey(c) || set.get(c) < subset.get(c)) 
				return false;
		return true;
	}
	
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0)
			return "";
		Map<Character, Integer> mapt = new HashMap<Character, Integer>();
		int lent = t.length(),
			lens = s.length();
		for (int i = 0; i < lent; ++ i)
			mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0) + 1);
		Map<Character, Integer> status = new HashMap<Character, Integer>();
		int i = 0, j = 0, min = Integer.MAX_VALUE;
		String minStr = "";
		boolean isSubSet = false;
		while (j < lens) {
			status.put(s.charAt(j), status.getOrDefault(s.charAt(j), 0) + 1);
			if (isSubSet || subset(mapt, status)) {
				while (!mapt.containsKey(s.charAt(i)) || status.get(s.charAt(i)) - 1 >= mapt.get(s.charAt(i))) {
					status.put(s.charAt(i), status.get(s.charAt(i)) - 1);
					i ++;
				}
				if (j - i + 1< min) {
					min = j - i + 1;
					minStr = s.substring(i, j + 1);
				}
				isSubSet = true;
			}
			j ++;
		}
		return minStr;
	}
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		T76 t76 = new T76();
		System.out.println(t76.minWindow(s, t));
	}

}
