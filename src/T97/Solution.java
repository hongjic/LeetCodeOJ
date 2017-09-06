package T97;

public class Solution {

	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		char[] ss1 = s1.toCharArray(), ss2 = s2.toCharArray(), ss3 = s3.toCharArray();
		if (len1 + len2 != len3) return false;
		boolean[][] f = new boolean[len1 + 1][len2 + 1];
		f[0][0] = true;
		for (int i = 1; i <= len1; i ++)
			if (s1.substring(0, i).equals(s3.substring(0, i))) f[i][0] = true;
			else break;
		for (int i = 1; i <= len2; i ++)
			if (s2.substring(0, i).equals(s3.substring(0, i))) f[0][i] = true;
			else break;
		for (int i = 1; i <= len1; i ++)
			for (int j = 1; j <= len2; j ++) {
				if (f[i - 1][j] && ss1[i - 1] == ss3[i + j - 1] || f[i][j - 1] && ss2[j - 1] == ss3[i + j - 1])
					f[i][j] = true;
			}
		return f[len1][len2];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

}
