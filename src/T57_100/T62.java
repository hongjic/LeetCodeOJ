package T57_100;

public class T62 {

	private int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) return 0;
		int[][] f = new int[m][n];
		for (int i = 0; i < m; i ++)
			f[i][0] = 1;
		for (int i = 0; i < n; i ++)
			f[0][i] = 1;
		for (int i = 1; i < m; i ++)
			for (int j = 1; j < n; j ++)
				f[i][j] = f[i - 1][j] + f[i][j - 1];
		return f[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T62 t62 = new T62();
		System.out.println(t62.uniquePaths(3, 7));
	}
}
