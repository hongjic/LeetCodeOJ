package T276;

public class Solution {

	public int numWays(int n, int k) {
		if (n == 0) return 0;
		if (n == 1) return k;
		if (n == 2) return k * k;
		int[] f = new int[n];
		f[0] = k;
		f[1] = k * k;
		for (int i = 2; i < n; i ++)
			f[i] = (k - 1) * (f[i - 1] + f[i - 2]);
		return f[n - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().numWays(3, 3));
	}

}
