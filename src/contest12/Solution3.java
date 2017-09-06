package contest12;

public class Solution3 {

	public int findMaxForm(String[] strs, int m, int n) {
		if (strs == null || strs.length == 0) return 0;
		int len = strs.length;
		int[] cost0 = new int[len];
		int[] cost1 = new int[len];
		for (int i = 0; i < len; i ++) {
			int length = strs[i].length();
			for (int j = 0; j < length; j ++)
				if (strs[i].charAt(j) == '0')
					cost0[i] ++;
			cost1[i] = length - cost0[i];
		}
		int[][] f = new int[m + 1][n + 1];
		for (int i = 0; i < len; i ++)
			for (int vm = m; vm >= cost0[i]; vm --)
				for (int vn = n; vn >= cost1[i]; vn --)
					f[vm][vn] = Math.max(f[vm][vn], f[vm - cost0[i]][vn - cost1[i]] + 1);
		return f[m][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 sol = new Solution3();
//		String[] strs = new String[] {"10", "0001", "111001", "1", "0"};
//		int m = 5, n = 3;
		String[] strs = new String[] {"10", "0", "1"};
		int m = 1, n = 1;
		System.out.println(sol.findMaxForm(strs, m, n));
	}

}
