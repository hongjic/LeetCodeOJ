package T674;

public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1, len = 0;
        for (int i = 0; i < nums.length; i ++)
            if (i == 0) len = 1;
            else if (nums[i] > nums[i - 1]) {
                len ++;
                max = Math.max(max, len);
            }
            else {
                len = 1;
            }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLengthOfLCIS(new int[] {2, 2,2}));
    }
}
