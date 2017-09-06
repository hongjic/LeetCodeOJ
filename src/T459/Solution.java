package T459;

public class Solution {

	public boolean repeatedSubstringPattern(String str) {
		int len = str.length();
		int[] next = new int[len];
		for (int i = 1; i < len; i ++) {
			int j = next[i - 1];
			while (j > 0 && str.charAt(j) != str.charAt(i))
				j = next[j - 1];
			if (str.charAt(j) == str.charAt(i))
				next[i] = j + 1;
		}
		
		// if the end of next[] is an ascending array and next[str.length() - 1] is larger than half length
		int subLen = len - next[len - 1];
		if (next[len - 1] * 2 >= len && len / subLen * subLen == len) {
			for (int i = 2; subLen * i <= len; i ++)
				if (next[subLen * i - 1] != subLen * (i - 1)) return false;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abaababaab";
		System.out.println(new Solution().repeatedSubstringPattern(str));
	}

}
