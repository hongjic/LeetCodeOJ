package T57_100;

public class T59 {

	private int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if (n == 0) return matrix;
		int count = 0, x = 0, y = 0;
		matrix[x][y] = ++ count;
		boolean flag = false;
		while (true) {
			flag = false;
			while (y < n - 1 && matrix[x][y + 1] == 0) {
				matrix[x][++ y] = ++ count;
				flag = true;
			}
			while (x < n - 1 && matrix[x + 1][y] == 0) {
				matrix[++ x][y] = ++ count;
				flag = true;
			}
			while (y >= 1 && matrix[x][y - 1] == 0) {
				matrix[x][-- y] = ++ count;
				flag = true;
			}
			while (x >= 1 && matrix[x - 1][y] == 0) {
				matrix[-- x][y] = ++ count;
				flag = true;
			}
			if (!flag) break;
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T59 t59 = new T59();
		int n = 4;
		int[][] matrix = t59.generateMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) 
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}

}
