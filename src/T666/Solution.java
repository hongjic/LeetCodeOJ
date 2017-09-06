package T666;

import java.util.Arrays;

public class Solution {

    private int sum = 0;

    /*
    if there is nothing, return false
     */
    private boolean pathSum(int[] nums, int pathSum, int d, int p) {
        int index = Arrays.binarySearch(nums, d * 100 + p * 10);
        if (index < 0) index = -index - 1;
        if (index == nums.length || (nums[index] /100 != d || nums[index] / 10 % 10 != p)) {
            return true;
        }
        boolean isLeaf = true;
        isLeaf = pathSum(nums, pathSum + nums[index] % 10, d + 1, 2 * p-1) && isLeaf;
        isLeaf = pathSum(nums, pathSum + nums[index] % 10, d + 1, 2 * p) && isLeaf;
        if (isLeaf)
            sum += pathSum + nums[index] % 10;
        return false;
    }

    public int pathSum(int[] nums) {
        pathSum(nums, 0, 1, 1);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pathSum(new int[]{}));
    }
}
