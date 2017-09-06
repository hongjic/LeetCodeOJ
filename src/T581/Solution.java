package T581;

public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len <= 1) return 0;
        int[] min = new int[len];
        int[] max = new int[len];

        for (int i = 0; i < len; i ++)
            if (i == 0) max[i] = nums[i];
            else max[i] = Math.max(max[i - 1], nums[i]);

        for (int i = len - 1; i >= 0; i --)
            if (i == len - 1) min[i] = nums[i];
            else min[i] = Math.min(min[i + 1], nums[i]);

        int left = 0, right = len - 1;

        while (left < len - 2 && nums[left] <= min[left + 1]) left ++;
        if (nums[left] <= min[left + 1]) return 0; // sorted array

        while (right >= 1 && nums[right] >= max[right - 1]) right --;
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        System.out.println(new Solution().findUnsortedSubarray(new int[]{1,2,0,5,4}));
        System.out.println(new Solution().findUnsortedSubarray(new int[]{1}));
        System.out.println(new Solution().findUnsortedSubarray(new int[]{}));

    }
}
