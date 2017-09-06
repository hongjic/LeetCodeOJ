package T12_56;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class T37 {
	
	private static int[][] d = {{0,0}, {0,1}, {1,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};

	private static boolean solve(char[][] board, Set<Integer>[][] set) {
		//find the element which has least possibilities
		int min = 10, min_x = -1, min_y = -1;
		for (int i=0; i<9; i++)
			for (int j=0; j<9; j++)
				if (board[i][j]=='.' && set[i][j].size()<min) {
					min = set[i][j].size();
					min_x = i;
					min_y = j;
				}
		if (min==10) 
			return true;
		// try all possibilities.
		Set<Integer> p = set[min_x][min_y];
		List<Integer> mx = new ArrayList<Integer>();
		List<Integer> my = new ArrayList<Integer>();
		for (int number: p) {
			//update set and board
			mx.clear();my.clear();
			for (int i=0; i<9; i++) {
				if (i!=min_y && board[min_x][i]=='.' && set[min_x][i].contains(number)) {
					set[min_x][i].remove(number);
					mx.add(min_x);my.add(i);
				}
				if (i!=min_x && board[i][min_y]=='.' && set[i][min_y].contains(number)) {
					set[i][min_y].remove(number);
					mx.add(i);my.add(min_y);
				}
				int xx = min_x/3*3+d[i][0], yy = min_y/3*3+d[i][1];
				if ((xx!=min_x || yy!=min_y) && board[xx][yy]=='.' && set[xx][yy].contains(number)) {
					set[xx][yy].remove(number);
					mx.add(xx);my.add(yy);
				}
			}
			board[min_x][min_y] = (char) (number+48);
			//try next
			if (solve(board, set)) return true;
			//recover set
			for (int i=0; i<mx.size(); i++)
				set[mx.get(i)][my.get(i)].add(number);
			board[min_x][min_y] = '.';
		}
		return false;
	}
	

	public static void solveSudoku(char[][] board) {
		Set<Integer>[][] set = new Set[9][9];
		for (int i=0; i<9; i++)
			for (int j=0; j<9; j++) 
				if (board[i][j]=='.'){
					set[i][j] = new HashSet<Integer>();
					set[i][j].addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
				}
		for (int i=0; i<9; i++)
			for (int j=0; j<9; j++) 
				if (board[i][j]=='.') {
					//delete numbers shown in same line
					for (int k=0; k<9; k++)
						if (board[i][k]!='.')
							set[i][j].remove(board[i][k]-48);
					//delete numbers shown in same column
					for (int k=0; k<9; k++)
						if (board[k][j]!='.')
							set[i][j].remove(board[k][j]-48);
					//delete numbers shown in same box
					int ox = i/3*3,
						oy = j/3*3;
					for (int k=0; k<9; k++)
						if (board[ox+d[k][0]][oy+d[k][1]]!='.')
							set[i][j].remove(board[ox+d[k][0]][oy+d[k][1]]-48);
				}
		solve(board, set);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'.', '.', '9', '7', '4', '8', '.', '.', '.'},
				{'7', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '2', '.', '1', '.', '9', '.', '.', '.'},
				{'.', '.', '7', '.', '.', '.', '2', '4', '.'},
				{'.', '6', '4', '.', '1', '.', '5', '9', '.'},
				{'.', '9', '8', '.', '.', '.', '3', '.', '.'},
				{'.', '.', '.', '8', '.', '3', '.', '2', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '6'},
				{'.', '.', '.', '2', '7', '5', '9', '.', '.'}
		};
		solveSudoku(board);
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}

}






//public class Solution {
//    private boolean[][] vis1;
//    private boolean[][] vis2;
//    private boolean[][] vis3;
//    private boolean isFound;
//
//    public void backTracking(char[][] board, int x, int y) {
//        if(x == 9) {
//            isFound = true;
//            return;
//        }
//        int z = x / 3 * 3 + y / 3;
//        if(board[x][y] == '.') {
//            for(int i = 1; i <= 9; ++i) {
//                int num = i - 1;
//                if(vis1[x][num] == false && vis2[y][num] == false && vis3[z][num] == false) {
//                    char ch = (char)(i + '0');
//                    board[x][y] = ch;
//                    vis1[x][num] = true;
//                    vis2[y][num] = true;
//                    vis3[z][num] = true;
//                    if(y == 8)
//                        backTracking(board, x + 1, 0);
//                    else
//                        backTracking(board, x, y + 1);
//                    if(isFound == true)
//                        break;
//                    board[x][y] = '.';
//                    vis1[x][num] = false;
//                    vis2[y][num] = false;
//                    vis3[z][num] = false;
//                }
//            }
//        } else {
//            int num = board[x][y] - '0' - 1;
//            vis1[x][num] = true;
//            vis2[y][num] = true;
//            vis3[z][num] = true;
//            if(y == 8)
//                backTracking(board, x + 1, 0);
//            else
//                backTracking(board, x, y + 1);
//        }
//    }
//
//    public void solveSudoku(char[][] board) {
//        vis1 = new boolean[9][9];
//        vis2 = new boolean[9][9];
//        vis3 = new boolean[9][9];
//        isFound = false;
//        for(int i = 0; i < 9; ++i) {
//            for(int j = 0; j < 9; ++j) {
//                if(board[i][j] != '.') {
//                    int num = board[i][j] - '0' - 1;
//                    int k = i / 3 * 3 + j / 3;
//                    vis1[i][num] = true;
//                    vis2[j][num] = true;
//                    vis3[k][num] = true;
//                }
//            }
//        }
//        backTracking(board, 0, 0);
//    }
//}