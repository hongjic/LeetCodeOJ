package T555;

public class Solution {

	public int checkRecord(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		int[][][] f = new int[n][2][3];
		f[0][0][0] = 1; f[0][0][1] = 1; f[0][0][2] = 0;
		f[0][1][0] = 1; f[0][1][1] = 0; f[0][1][2] = 0;
		for (int i = 1; i < n; i ++) {
			f[i][0][0] = ((f[i - 1][0][0] + f[i - 1][0][1]) % 1000000007 + f[i - 1][0][2]) % 1000000007;
			f[i][0][1] = f[i - 1][0][0];
			f[i][0][2] = f[i - 1][0][1];
			for (int j = 0; j <= 1; j ++)
				for (int k = 0; k <= 2; k ++)
					f[i][1][0] = (f[i][1][0] + f[i - 1][j][k]) % 1000000007;
			f[i][1][1] = f[i - 1][1][0];
			f[i][1][2] = f[i - 1][1][1];
		}
		int sum = 0;
		for (int j = 0; j <= 1; j ++)
			for (int k = 0; k <= 2; k ++)
				sum = (sum + f[n - 1][j][k]) % 1000000007;
		return sum;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().checkRecord(2));
	}

}
