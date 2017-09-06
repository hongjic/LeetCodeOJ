package T506;

public class Solution {

    private void swap(int[] nums, int[] orders, int i, int j) {
        int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
        t = orders[i]; orders[i] = orders[j]; orders[j] = t;
    }

    private void quickSort(int[] nums, int[] orders, int left, int right) {
        int i = left, j = right;
        int pivot = nums[left];
        while (i <= j) {
            while (i < nums.length && nums[i] > pivot) i ++;
            while (j > 0 & nums[j] < pivot) j --;
            if (i <= j)
                swap(nums, orders, i ++, j --);
        }
        if (left < j)
            quickSort(nums, orders, left, j);
        if (right > i)
            quickSort(nums, orders, i, right);
    }

    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[] orders = new int[len];

        for (int i = 0; i < len; i ++)
            orders[i] = i;

        quickSort(nums, orders, 0, len - 1);

        String[] res = new String[len];
        for (int i = 0; i < len; i ++) {
            if (i == 0) res[orders[0]] = "Gold Medal";
            else if (i == 1) res[orders[1]] = "Silver Medal";
            else if (i == 2) res[orders[2]] = "Bronze Medal";
            else res[orders[i]] = String.valueOf(i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findRelativeRanks(new int[]{10,3,8,9,4}));
    }
}
