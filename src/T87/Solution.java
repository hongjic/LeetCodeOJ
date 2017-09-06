package T87;

public class Solution {

	private Boolean[][][][] f;
	
	public boolean isScramble(String s1, String s2) {
		char[] w1 = s1.toCharArray();
		char[] w2 = s2.toCharArray();
		int len1 = w1.length, len2 = w2.length;
		if (len1 != len2) return false;
		f = new Boolean[len1][len1][len2][len2];
		return isScramble(w1, w2, 0, len1 - 1, 0, len2 - 1);
	}
	
	private boolean isScramble(char[] w1, char[] w2, int s1, int e1, int s2, int e2) {
		if (f[s1][e1][s2][e2] != null) return f[s1][e1][s2][e2];
		if (e1 == s1 && e2 == s2 && w1[e1] == w2[e2]) {
			f[s1][e1][s2][e2] = true;
			return true;
		}
		int[] letters = new int[26];
		for (int i = 0; i <= e1 - s1; i ++) {
			letters[w1[s1 + i] - 'a'] ++;
			letters[w2[s2 + i] - 'a'] --;
		}
		for (int i = 0; i < 26; i ++) 
			if (letters[i] != 0) {
				f[s1][e1][s2][e2] = false;
				return false;
			}
			
		for (int len = 1; len <= e1 - s1; len ++) {
			if (isScramble(w1, w2, s1, s1 + len - 1, e2 - len + 1, e2) && isScramble(w1, w2, s1 + len, e1, s2, e2 - len)
					|| isScramble(w1, w2, s1, s1 + len - 1, s2, s2 + len - 1) && isScramble(w1, w2, s1 + len, e1, s2 + len, e2)) {
				f[s1][e1][s2][e2] = true;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isScramble("a", "a"));
	}

}
