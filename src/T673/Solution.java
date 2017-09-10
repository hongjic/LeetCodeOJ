package T673;

public class Solution {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] f = new int[n][2];
        for (int i = 0 ; i < n; i ++) {
            f[i][0] = 1;
            f[i][1] = 1;
        }

        int maxlen = 1, max = 1;
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < i; j ++)
                if (nums[j] < nums[i]) {
                    if (f[j][0] + 1 > f[i][0]) {
                        f[i][0] = f[j][0] + 1;
                        f[i][1] = f[j][1];
                    }
                    else if (f[j][0] + 1 == f[i][0]) {
                        f[i][1] += f[j][1];
                    }
                }
            if (f[i][0] == maxlen) max += f[i][1];
            if (f[i][0] > maxlen) {
                maxlen = f[i][0];
                max = f[i][1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNumberOfLIS(new int[] {1,3,5,4,7}));
        System.out.println(new Solution().findNumberOfLIS(new int[] {2,2,2,2,2}));
        System.out.println(new Solution().findNumberOfLIS(new int[] {1,1,1,2,2,2,3,3,3}));
    }

}
