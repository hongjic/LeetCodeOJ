package T562;

public class Solution {

    public int longestLine(int[][] N) {
        int rows = N.length;
        if (rows == 0) return 0;
        int cols = N[0].length;
        if (cols == 0) return 0;
        int max = 0;

        // horizontal
        for (int i = 0; i < rows; i ++) {
            int len = 0;
            for (int j = 0; j < cols; j ++)
                if (N[i][j] == 1) {
                    if (j == 0 || N[i][j - 1] == 0) {
                        len = 1;
                        max = Math.max(max, len);
                    }
                    else {
                        len ++;
                        max = Math.max(max, len);
                    }
                }
        }

        // vertical
        for (int j = 0; j < cols; j ++) {
            int len = 0;
            for (int i = 0; i < rows; i ++)
                if (N[i][j] == 1) {
                    if (i == 0 || N[i - 1][j] == 0) {
                        len = 1;
                        max = Math.max(max, len);
                    }
                    else {
                        len ++;
                        max = Math.max(max, len);
                    }
                }
        }

        // diagonal (+ 1, -1)
        int i = rows - 1, j = cols - 1;
        while (i >= 0 && j >= 0) {
            int len = 0, ii = i, jj = j;
            while (ii >= 0 && ii < rows && jj >=0 && jj < cols) {
                if (N[ii][jj] == 1) {
                    if ((ii == i && jj == j) || N[ii - 1][jj + 1] == 0) {
                        len = 1;
                        max = Math.max(max, len);
                    }
                    else {
                        len ++;
                        max = Math.max(max, len);
                    }
                }
                ii ++; jj --;
            }
            if (i > 0) i --;
            else j --;
        }

        // anti-diagonal (+1, +1)
        i = 0; j = cols - 1;
        while (i < rows) {
            int len = 0, ii = i, jj = j;
            while (ii >= 0 && ii < rows && jj >= 0 && jj < cols) {
                if (N[ii][jj] == 1) {
                    if ((ii == i && jj == j) || N[ii - 1][jj - 1] == 0) {
                        len = 1;
                        max = Math.max(max, len);
                    }
                    else {
                        len ++;
                        max = Math.max(max, len);
                    }
                }
                ii ++; jj ++;
            }
            if (j > 0) j --;
            else i ++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestLine(new int[][] {{0,1,1,0}, {0,1,1,0}, {0,0,1,1}, {0,0,1,0}}));
    }
}
