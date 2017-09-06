package T101_end;
import java.util.ArrayList;
import java.util.List;


public class T200 {
	private static final int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public int numIslands(char[][] grid) {
		int m = grid.length;
		if (m == 0) return 0;
		int n = grid[0].length;
		if (n == 0) return 0;
		int i = 0, j = 0, sum = 0;
		List<Integer> x = new ArrayList<Integer>();
		List<Integer> y = new ArrayList<Integer>();
		while (i < m && j < n) {
			if (grid[i][j] == '1') {
				int head = 0;
				x.clear(); y.clear();
				x.add(i); y.add(j);
				grid[i][j] = '0';
				while (head < x.size()) {
					int ii = x.get(head);
					int jj = y.get(head);
					for (int k = 0; k < 4; ++ k)
						if (ii+d[k][0]>=0 && ii+d[k][0]<m && jj+d[k][1]>=0 && jj+d[k][1]<n && grid[ii+d[k][0]][jj+d[k][1]] == '1') {
							x.add(ii+d[k][0]);
							y.add(jj+d[k][1]);
							grid[ii+d[k][0]][jj+d[k][1]] = '0';
						}
					++ head; 
				}
				++ sum;
			}
			while (grid[i][j] == '0') {
				++ j;
				if (j == n) {
					j = 0; ++ i;
				}
				if (i == m) break;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
		T200 t200 = new T200();
		System.out.println(t200.numIslands(grid));
		String a = "aaa";
		StringBuffer sb = new StringBuffer(a);
		System.out.println(sb.toString());
		
	}

}
