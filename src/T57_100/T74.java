package T57_100;

public class T74 {

	private boolean helper(int[][] matrix, int lx, int ly, int rx, int ry, int m, int n, int target) {
		if (lx == rx && ly == ry) {
			if (matrix[lx][ly] == target)
				return true;
			else return false;
		}
		int pp = ((rx-lx) * n + ry-ly)/2;
		int py = (ly + pp) % n,
			px = (ly + pp) / n + lx;
		if (matrix[px][py] == target)
			return true;
		if (matrix[px][py] < target) 
			return helper(matrix, px+(py+1)/n, (py+1)%n, rx, ry, m, n, target);
		else
			return helper(matrix, lx, ly, px, py, m, n, target);
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0) return false;
		int n = matrix[0].length;
		if (n == 0) return false;
		return helper(matrix, 0, 0, m-1, n-1, m, n, target);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T74 t74 = new T74();
		int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
		int target = 135;
		System.out.println(t74.searchMatrix(matrix, target));
	}

}
