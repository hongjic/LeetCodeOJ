package T329;

import java.util.HashMap;
import java.util.Map;

/*
Is this really a hard problem?
 */

public class Solution {

    private final static int[][] D = {{0, -1}, {-1,0}, {0, 1}, {1, 0}};
    private Map<Integer, Integer> longestPath;

    private int longestIncreasingPath(int[][] matrix, int x, int y, int rows, int cols) {
        if (longestPath.containsKey(x * cols + y))
            return longestPath.get(x * cols + y);

        int len = 1;
        for (int d = 0; d < 4; d ++) {
            if (x + D[d][0] >= 0 && x + D[d][0] < rows && y + D[d][1] >= 0 && y + D[d][1] < cols
                    && matrix[x + D[d][0]][y + D[d][1]] > matrix[x][y]) {
                len = Math.max(len, longestIncreasingPath(matrix, x + D[d][0], y + D[d][1], rows, cols) + 1);
            }
        }

        longestPath.put(x * cols + y, len);
        return len;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        if (cols == 0) return 0;

        longestPath = new HashMap<>();
        int res = 1;

        for (int i = 0; i < rows; i ++)
            for (int j = 0; j < cols; j ++)
                res = Math.max(res, longestIncreasingPath(matrix, i ,j, rows, cols));

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestIncreasingPath(new int[][] {{17,4,6,11,4,0,17,12,19,12,12,0},{0,6,4,4,5,9,15,1,11,13,18,0},{4,2,13,1,2,7,15,5,14,6,8,6}}));
        System.out.println(new Solution().longestIncreasingPath(new int[][] {{9,9,4}, {6,6,8}, {2,1,1}}));
        System.out.println(new Solution().longestIncreasingPath(new int[][] {{3,4,5}, {3,2,6}, {2,2,1}}));
    }
}
