package T643;

public class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < k; i ++) sum += nums[i];
        int max = sum;

        for (int i = k, j = 0; i < n; i ++, j ++) {
            sum += nums[i] - nums[j];
            max = Math.max(sum, max);
        }

        return (double)max / k;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
