package T161;

public class Solution {

	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null) return false;
		int lens = s.length(),
			lent = t.length();
		int count = 0;
		if (lens == lent) {
			for (int i = 0; i < lens; i ++)
				if (s.charAt(i) != t.charAt(i)) count ++;
			if (count == 1) return true;
		}
		if (Math.abs(lens - lent) != 1) return false;
		int i = 0, j = 0;
		boolean flag = false;
		while (i < lens && j < lent) {
			if (s.charAt(i) != t.charAt(j)) {
				if (!flag) {
					flag = true;
					if (lens > lent) i ++;
					else j ++;
					continue;
				}
				return false;
			}
			i ++; j ++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.isOneEditDistance("abd", "abd"));

	}

}
