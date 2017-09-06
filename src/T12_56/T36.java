package T12_56;
public class T36 {

	public static boolean isValidSudoku(char[][] board) {
		//check every line
		int[][] d = {{0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
		int[][] p = {{0,0}, {0,3}, {0,6}, {3,0}, {3,3}, {3,6}, {6,0}, {6,3}, {6,6}};
		boolean[] check = new boolean[10];
		//check every line
		for (int i=0; i<9; i++) {
			for (int j=0; j<10; j++)
				check[j] = false;
			for (int j=0; j<9; j++)
				if (board[i][j]!='.')
					if (check[board[i][j]-48]) 
						return false;
					else 
						check[board[i][j]-48] = true;
		}
		//check every column
		for (int j=0; j<9; j++) {
			for (int i=0; i<10; i++)
				check[i] = false;
			for (int i=0; i<9; i++)
				if (board[i][j]!='.')
					if (check[board[i][j]-48])
						return false;
					else
						check[board[i][j]-48] = true;
		}
		//check every box
		for (int i=0; i<9; i++) {
			//position
			for (int j=0; j<10; j++)
				check[j] = false;
			//box
			for (int j=0; j<9; j++) {
				int x = p[i][0]+d[j][0],
					y = p[i][1]+d[j][1];
				if (board[x][y]!='.')
					if (check[board[x][y]-48])
						return false;
					else
						check[board[x][y]-48] = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'.','8','7','6','5','4','3','2','1'}, 
			{'2','.','.','.','.','.','.','.','.'}, 
			{'3','.','.','.','.','.','.','.','.'}, 
			{'4','.','.','.','.','.','.','.','.'}, 
			{'5','.','.','.','.','.','.','.','.'}, 
			{'6','.','.','.','.','.','.','.','.'}, 
			{'7','.','.','.','.','.','.','.','.'}, 
			{'8','.','.','.','.','.','.','.','.'}, 
			{'9','.','.','.','.','.','.','.','.'}};
		System.out.println(isValidSudoku(board));
	}

}



//public class Solution {
//    public boolean isValidSudoku(char[][] board) {
//    int size = board.length;
//
//    for(int i = 0; i < size; i++)
//    {
//        boolean b1[] = new boolean[size];
//        for(int j = 0; j < size; j++)
//        {
//            if(board[i][j] != '.')
//            {
//                int diff = board[i][j] - '1';
//                if(b1[diff])
//                    return false;
//                b1[diff] = true;
//            }
//        }
//
//        boolean b2[] = new boolean[size];
//        for(int k = 0; k < size; k++)
//        {
//            if(board[k][i] != '.')
//            {
//                int diff = board[k][i] - '1';
//                if(b2[diff])
//                    return false;
//                b2[diff] = true;
//            }
//        }
//
//        boolean b3[] = new boolean[size];
//        for(int m = 0; m < size; m++)
//        {
//            int x = m / 3 + (i / 3) * 3;
//            int y = m % 3 + (i % 3) * 3;
//            if(board[x][y] != '.')
//            {
//                int diff = board[x][y] - '1';
//                if(b3[diff])
//                    return false;
//                b3[diff] = true;
//            }
//        }
//    }
//    return true;
//}
//}