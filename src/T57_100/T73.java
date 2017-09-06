package T57_100;

public class T73 {

	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		if (m == 0) return;
		int n = matrix[0].length;
		if (n == 0) return;
		boolean[] l = new boolean[m];
		boolean[] c = new boolean[n];
		for (int i = 0; i < m; ++ i)
			for (int j = 0; j < n; ++ j) {
				if (matrix[i][j] == 0) {
					l[i] = true;
					c[j] = true;
				}
			}
		for (int i = 0; i < m; ++ i)
			for (int j = 0; j < n; ++ j) 
				if (l[i] || c[j]) 
					matrix[i][j] = 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] matrix = {{0,1,2,3,4,5}, {1,0,2,3,4,5}, {3,4,5,6,7,8}, {4,3,5,6,7,8}, {1,2,3,4,5,6}, {2,3,4,5,6,0}};
		int[][] matrix = {{0,0,0,5}, {4,3,1,4}, {0,1,1,4},{1,2,1,3},{0,0,1,1}};
		T73 t73= new T73();
		t73.setZeroes(matrix);
		for (int i = 0; i < matrix.length; ++ i) {
			for (int j = 0; j < matrix[i].length; ++ j) 
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
	}

}
