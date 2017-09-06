package T101_end;

public class T311 {

	public int[][] multiply(int[][] A, int[][] B) {
		if (A == null || B == null) return null;
		int m = A.length;
		int n = B.length;
		int k = B[0].length;
		int[][] C = new int[m][k];
		for (int i = 0; i < m; i ++)
			for (int ii = 0; ii < n; ii ++)
				if (A[i][ii] != 0)
					for (int j = 0; j < k; j ++)
						if (B[ii][j] != 0)
							C[i][j] += A[i][ii] * B[ii][j];
		return C;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T311 t311 = new T311();
		int[][] A = {{1,0,0},{-1,0,3}};
		int[][] B = {{7,0,0},{0,0,0},{0,0,1}};
		int[][] C = t311.multiply(A, B);
		for (int i = 0; i < C.length; i ++) {
			for (int j = 0; j < C[0].length; j ++)
				System.out.print(C[i][j]);
			System.out.println();
		}
	}

}
