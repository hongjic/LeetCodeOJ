package T644;

public class Solution {

    private boolean existSubArrayWithHigherAverage(int[] nums, int k, double x) {
        double sum = 0, extra = 0;
        for (int i = 0; i < k; i ++)
            sum += nums[i] - x;
        if (sum > 0) return true;

        for (int i = k; i < nums.length; i ++) {
            sum += nums[i] - x;
            extra += nums[i - k] - x;
            if (extra < 0) {
                sum -= extra;
                extra = 0;
            }
            if (sum > 0) return true;
        }

        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        double min = -10000, max = 10000, mid = 0;
        while (max - min > 0.000001) {
            mid = (max + min) / 2;
            if (existSubArrayWithHigherAverage(nums, k, mid)) min = mid;
            else max = mid;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
