package T408;

public class Solution {

	public boolean validWordAbbreviation(String word, String abbr) {
		int len1 = word.length();
		int len2 = abbr.length();
		char[] w = word.toCharArray();
		char[] a = abbr.toCharArray();
		int i = 0, j = 0;
		while (i < len1 && j < len2) {
			if (a[j] >= 'a' && a[j] <= 'z') {
				if (a[j] != w[i]) return false;
				i ++; j ++;
				continue;
			}
			int num = 0;
			while (j < len2 && a[j] >= '0' && a[j] <= '9') {
				if (num == 0 && a[j] == '0') return false;
				num = num * 10 + a[j ++] - 48;
			}
			i += num;
		}
		if (i == len1 && j == len2) return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().validWordAbbreviation("a", "01"));
	}

}
