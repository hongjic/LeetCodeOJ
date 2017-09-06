package T79;

public class Solution {

	private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public boolean exist(char[][] board, String word) {
		int lenx = board.length,
			leny = board[0].length;
		boolean[][] visited = new boolean[lenx][leny];
		for (int i = 0; i < lenx; i ++) {
			for (int j = 0; j < leny; j ++)
				if (board[i][j] == word.charAt(0)) {
					visited[i][j] = true;
					if (search(board, visited, lenx, leny, i, j, word, 1)) return true;
					visited[i][j] = false;
				}
		}
		return false;
	}
	
	private boolean search(char[][] board, boolean[][] visited, int lenx, int leny, int i, int j, String word, int index) {
		if (index == word.length())
			return true;
		for (int d = 0; d < 4; d ++) {
			int x = i + dir[d][0];
			int y = j + dir[d][1];
			if ((x >= 0 && x < lenx && y >= 0 && y < leny) && board[x][y] == word.charAt(index)
					&& !visited[x][y]) {
				visited[i][j] = true;
				if (search(board, visited, lenx, leny, x, y, word, index + 1)) return true;
				visited[i][j] = false;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
		String word = "ABCCED";
		System.out.println(sol.exist(board, word));
	}

}
