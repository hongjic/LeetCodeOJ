package T477;

public class Solution {

    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int i = 0; i < 32; i ++) {
            int count = 0;
            for (int j = 0; j < n; j++)
                count += (nums[j] >> i) & 1;
            total += count * (n - count);
        }
        return total;
    }
}
