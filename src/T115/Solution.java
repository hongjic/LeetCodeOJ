package T115;

public class Solution {

	
	// this dp solution only depend on previous state, so actually it can remove one dimension.
	public int numDistinct(String s, String t) {
		int lenS = s.length();
		int lenT = t.length();
		if (lenT == 0) return 1;
		if (lenS == 0) return 0;
		int[][] f = new int[lenS][lenT];
		for (int i = 0; i < lenT; i ++)
			f[0][i] = 0;
		for (int i = 0; i < lenS; i ++)
			if (s.charAt(i) == t.charAt(0)) f[i][0] = 1;
		for (int j = 1; j < lenT; j ++) {
			int sum = 0;
			for (int i = j; i < lenS; i ++) {
				sum += f[i - 1][j - 1];
				if (s.charAt(i) == t.charAt(j)) 
					f[i][j] = sum;
			}
		}
		int result = 0;
		for (int i = 0; i < lenS; i ++)
			result += f[i][lenT - 1];
		return result;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().numDistinct("rabbbit", "rabbit"));
	}

}
