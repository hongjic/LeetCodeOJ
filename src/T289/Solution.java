package T289;

public class Solution {

	private static final int[][] D = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
	
	// 01 live->die
	// 11 live->live
	// 10 die->live  next -> current
	// 00 die->die
	
	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++) {
				int nei = neighbors(board, i, j, m, n);
				if (board[i][j] == 1) {
					if (nei < 2 || nei > 3)
						board[i][j] = 1;
					else
						board[i][j] = 3;
				}
				else {
					if (nei == 3)
						board[i][j] = 2;
					else
						board[i][j] = 0;
				}
			}
		
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++)
				board[i][j] >>= 1;
	}
	
	private int neighbors(int[][] board, int x, int y, int m, int n) {
		int sum = 0;
		for (int i = 0; i < 8; i ++) {
			int xx = x + D[i][0];
			int yy = y + D[i][1];
			if (xx >= 0 && xx < m && yy >= 0 && yy < n && (board[xx][yy] & 1) == 1)
				sum ++;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = new int[][]{{1,0,0,1},{0,1,0,0},{1,1,0,1},{0,0,0,1}};
		new Solution().gameOfLife(board);
		for (int i = 0; i < board.length; i ++) {
			for (int j = 0; j < board[i].length; j ++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}

}
