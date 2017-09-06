package T57_100;

public class T63 {

	private int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int m = obstacleGrid.length,
			n = obstacleGrid[0].length;
		int[][] f = new int[m][n];
		int i = 0, j = 0;
		while (i < m && obstacleGrid[i][0] == 0) {
			f[i][0] = 1;
			i ++;
		}
		while (j < n && obstacleGrid[0][j] == 0) {
			f[0][j] = 1;
			j ++;
		}
		for (i = 1; i < m; i ++)
			for (j = 1; j < n; j ++)
				if (obstacleGrid[i][j] == 0) 
					f[i][j] = f[i - 1][j] + f[i][j - 1]; 
		return f[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T63 t63 = new T63();
		int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		System.out.println(t63.uniquePathsWithObstacles(obstacleGrid));
	}

}
