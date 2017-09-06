package T482;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	// Weekly Contest 14: License Key Formatting
	public String licenseKeyFormatting(String s, int k) {
		int len = s.length();
		List<String> res = new ArrayList<String>();
		StringBuilder cur = new StringBuilder();
		int count = 0;
		for (int i = len - 1; i >= 0; i --) {
			if (s.charAt(i) != '-') {
				count ++;
				cur.insert(0, Character.toUpperCase(s.charAt(i)));
				if (count == k) {
					res.add(cur.toString());
					cur = new StringBuilder();
					count = 0;
				}
			}
		}
		if (count != 0) res.add(cur.toString());
		StringBuilder sb = new StringBuilder();
		if (res.size() > 0) {
			for (int i = res.size() - 1; i >= 1; i --)
				sb.append(res.get(i)).append('-');
			sb.append(res.get(0));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().licenseKeyFormatting("---", 3));
		System.out.println(new Solution().licenseKeyFormatting("2-4A0r7-4k", 3));
		System.out.println(new Solution().licenseKeyFormatting("2-4A0r7-4k", 4));
	}

}
