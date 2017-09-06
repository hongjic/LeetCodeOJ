package T471;

import java.util.Map;
import java.util.HashMap;

public class Solution {
	
	Map<String, String> map = new HashMap<>();

	public String encode(String s) {
		if (s == null || s.length() <= 3)
			return s;
		if (map.containsKey(s))
			return map.get(s);
		String ans = s;
		// consider self-compress
		for (int len = 1; len < s.length(); len ++)
			if (s.length() % len == 0) {
				boolean flag = true;
				for (int i = 0, j = 0; i < s.length(); i ++, j = (j + 1) % len)
					if (s.charAt(i) != s.charAt(j)) {
						flag = false;
						break;
					}
				if (flag) {
					String compressed = String.format("%d[%s]", s.length() / len, encode(s.substring(0, len)));
					if (compressed.length() < ans.length())
						ans = compressed;
				}
			}
		
		// divide into two parts
		for (int div = 1; div < s.length(); div ++) {
			String left = encode(s.substring(0, div));
			String right = encode(s.substring(div, s.length()));
			if (left.length() + right.length() < ans.length())
				ans = left + right;
		}
		map.put(s, ans);
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.encode("abbbabbbcabbbabbbc"));
	}

}
