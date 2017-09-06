package T12_56;
import java.util.ArrayList;
import java.util.List;


public class T51 {

	private void setBoard(boolean[][] board, int x, int y, boolean value, int n) {
		//line and row
		for (int i=0; i<n; i++) {
			board[x][i] = value;
			board[i][y] = value;
		}
		// xieduijiao
		int xx = x+1, yy = y+1;
		while (xx<n && yy<n) {
			board[xx][yy] = value;
			xx++; yy++;
		}
		xx = x+1; yy = y-1;
		while (xx<n && yy>=0) {
			board[xx][yy] = value;
			xx++; yy--;
		}
		xx = x-1; yy = y+1;
		while (xx>=0 && yy<n) {
			board[xx][yy] = value;
			xx--; yy++;
		}
		xx = x-1; yy = y-1;
		while (xx>=0 && yy>=0) {
			board[xx][yy] = value;
			xx--; yy--;
		}
	}
	
	private void helper(List<List<String>> solutions, int[] q_position, boolean[][] board, int index, int n) {
		if (index == n) {
			List<String> solution = new ArrayList<String>();
			for (int i=0; i<n; i++) {
				char[] line = new char[n];
				for (int j=0; j<n; j++) line[j] = '.';
				line[q_position[i]] = 'Q';
				solution.add(String.valueOf(line));
			}
			solutions.add(solution);
			return;
		}
		// backup deep copy
		boolean[][] backup = new boolean[n][n];
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				backup[i][j] = board[i][j];
		for (int i=0; i<n; i++)
			if (!board[index][i]) {
				q_position[index] = i;
				//update line, row and "xieduijiao" on board
				setBoard(board, index, i, true, n);
				helper(solutions, q_position, board, index+1, n);
				// recovery board
				for (int p1=0; p1<n; p1++)
					for (int p2=0; p2<n; p2++)
						board[p1][p2] = backup[p1][p2];
			}
	}
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> solutions = new ArrayList<List<String>>();
		if (n == 0)
			return solutions;
		int[] q_position = new int[n];
		boolean[][] board = new boolean[n][n];
		helper(solutions, q_position, board, 0, n);
		return solutions;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T51 t51 = new T51();
		List<List<String>> res = t51.solveNQueens(5);
		for (int i=0; i<res.size(); i++) {
			for (int j=0; j<res.get(i).size(); j++)
				System.out.println(res.get(i).get(j));
			System.out.println();
		}
				
	}

}







//public class Solution {
//    public List<List<String>> solveNQueens(int n) {
//    List<List<String>> ret = new ArrayList<>();
//    dfs(n, 0, new int[n], new ArrayList<>(), ret);
//    return ret;
//}
//
//private void dfs(int n, int idx, int[] valid, List<String> path, List<List<String>> ret) {
//    if (path.size() == n) {
//        ret.add(path);
//    }
//    for (int j = 0; j < n; j++) {
//        if (checkValid(valid, idx, j)) {
//            valid[idx] = j;
//            String s = String.join("", Collections.nCopies(j, "."))+"Q"+
//            String.join("", Collections.nCopies(n-j-1, "."));
//            List<String> p = new ArrayList<>(path);
//            p.add(s);
//            dfs(n, idx+1, valid, p, ret);
//        }
//    }
//
//}
//
//private boolean checkValid(int[] valid, int r, int c) {
//    for (int i = 0; i < r; i++) {
//        if (valid[i] == c || (r-i) == Math.abs(c-valid[i])) {
//            return false;
//        }
//    }
//    return true;
//}
//}