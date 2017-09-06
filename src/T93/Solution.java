package T93;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		int len = s.length();
		for (int p1 = 0; p1 <= Math.min(2, len - 4); p1 ++) {
			int num1 = Integer.valueOf(s.substring(0, p1 + 1));
			if (num1 < 0 || num1 > 255) continue;
			if (s.charAt(0) == '0' && p1 > 0) continue;
			for (int p2 = p1 + 1; p2 <= Math.min(p1 + 3, len - 3); p2 ++) {
				int num2 = Integer.valueOf(s.substring(p1 + 1, p2 + 1));
				if (num2 < 0 || num2 > 255) continue;
				if (s.charAt(p1 + 1) == '0' && p2 > p1 + 1) continue;
				for (int p3 = p2 + 1; p3 <= Math.min(p2 + 3, len - 2); p3 ++) {
					if (s.charAt(p2 + 1) == '0' && p3 > p2 + 1) continue;
					int num3 = Integer.valueOf(s.substring(p2 + 1, p3 + 1));
					if (len - 1 - p3 > 3 || s.charAt(p3 + 1) == '0' && len - 1 - p3 > 1) continue;
					int num4 = Integer.valueOf(s.substring(p3 + 1, len));
					if (num3 >= 0 && num3 <= 255 && num4 >= 0 && num4 <= 255)
						res.add(String.valueOf(num1) + '.' + String.valueOf(num2) + '.' + String.valueOf(num3) + '.' + String.valueOf(num4));					
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = new Solution().restoreIpAddresses("0279245587303");
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i));
	}

}
