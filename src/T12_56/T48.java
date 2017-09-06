package T12_56;
public class T48 {

	private void rotate_element(int[][] matrix, int i, int j, int n) {
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[n-j-1][i];
		matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
		matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
		matrix[j][n-i-1] = tmp;
	}
	
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n<=1) return;
		if ((n&1)==1) 
			for (int i=0; i<=n/2; i++)
				for (int j=0; j<=n/2-1; j++)
					rotate_element(matrix, i, j, n);
		else
			for (int i=0; i<=n/2-1; i++)
				for (int j=0; j<=n/2-1; j++)
					rotate_element(matrix, i, j, n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T48 t48 = new T48();
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int len = matrix.length;
		t48.rotate(matrix);
		for (int i=0; i<len; i++) {
			for (int j=0; j<len; j++)
				System.out.print(matrix[i][j]);
			System.out.println();
		}
	}
}











//public class Solution {
//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//        int start = 0, end = n - 1;
//        for(int i = 0; i < n/2; i++){ //iterate layer
//            for(int j = 0; j < end - start; j++) {
//                int tmp = matrix[start][start+j];
//                matrix[start][start+j] = matrix[end-j][start];
//                matrix[end-j][start] = matrix[end][end-j];
//                matrix[end][end-j] = matrix[start+j][end];
//                matrix[start+j][end] = tmp;
//            }
//            start++;
//            end--;
//        }
//    }
//}