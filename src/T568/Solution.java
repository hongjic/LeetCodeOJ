package T568;

import java.util.Arrays;

public class Solution {

    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length, k = days[0].length;
        int[][] f = new int[k][n];
        for (int i = 0; i < k; i ++)
            Arrays.fill(f[i], Integer.MIN_VALUE);
        for (int i = 0; i < n; i ++)
            if (i == 0 || flights[0][i] == 1) f[0][i] = days[i][0];

        for (int i = 1; i < k; i ++) {

            for (int c2 = 0; c2 < n; c2 ++) {
                for (int c1 = 0; c1 < n; c1 ++)
                    if (c1 == c2 || flights[c1][c2] == 1)
                        f[i][c2] = Math.max(f[i][c2], f[i - 1][c1] + days[c2][i]);

            }
        }

        int max = 0;
        for (int i = 0; i < n; i ++)
            max = Math.max(max, f[k - 1][i]);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxVacationDays(new int[][] {{0,1,1}, {1,0,1}, {1,1,0}}, new int[][]{{1,3,1}, {6,0,3}, {3,3,3}}));
        System.out.println(new Solution().maxVacationDays(new int[][] {{0,0,0}, {0,0,0}, {0,0,0}}, new int[][]{{1,1,1}, {7,7,7}, {7,7,7}}));
        System.out.println(new Solution().maxVacationDays(new int[][] {{0,1,1}, {1,0,1}, {1,1,0}}, new int[][]{{7,0,0}, {0,7,0}, {0,0,7}}));
    }
}
