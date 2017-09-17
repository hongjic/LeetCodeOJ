package T679;

public class Solution {

    private boolean judgePoint24(double[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0] == 24;

        double[] nextNums = new double[len - 1];

        for (int i = 0; i < len; i ++)
            for (int j = i + 1; j < len; j ++) {
                int index = 0;
                for (int k = 0; k < len; k ++)
                    if (k != i && k != j)
                        nextNums[index ++] = nums[k];

                nextNums[index] = nums[i] + nums[j];
                if (judgePoint24(nextNums)) return true;
                nextNums[index] = nums[i] - nums[j];
                if (judgePoint24(nextNums)) return true;
                nextNums[index] = -nums[i] + nums[j];
                if (judgePoint24(nextNums)) return true;
                nextNums[index] = nums[i] * nums[j];
                if (judgePoint24(nextNums)) return true;
                if (nums[j] != 0) {
                    nextNums[index] = nums[i] / nums[j];
                    if (judgePoint24(nextNums)) return true;
                }
                if (nums[i] != 0) {
                    nextNums[index] = nums[j] / nums[i];
                    if (judgePoint24(nextNums)) return true;
                }
            }
        return false;
    }

    public boolean judgePoint24(int[] nums) {
        double[] set = new double[4];
        for (int i = 0; i < 4; i ++)
            set[i] = nums[i];
        return judgePoint24(set);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgePoint24(new int[]{1,5,9,1}));
        System.out.println(new Solution().judgePoint24(new int[]{4,1,8,7}));
        System.out.println(new Solution().judgePoint24(new int[]{1,2,1,2}));
    }
}
