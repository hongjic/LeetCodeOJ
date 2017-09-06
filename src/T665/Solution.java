package T665;

public class Solution {

    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 2) return true;
        int n = nums.length;
        int i = 0;
        while (i < n - 1 && nums[i] <= nums[i + 1]) i ++;
        if (i == n - 1) return true;
        int a = i, b = i + 1;
        i ++;
        while (i < n - 1 && nums[i] <= nums[i + 1]) i++;
        if (i < n - 1) return false;
        if (a == 0 || b == n - 1) return true;
        if (nums[a] <= nums[b + 1] || nums[a - 1] <= nums[b]) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkPossibility(new int[] {1,2,3,4,5}));
    }

}
