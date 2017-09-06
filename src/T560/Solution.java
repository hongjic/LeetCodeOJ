package T560;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        int sum = 0, res = 0;

        for (int i = 0; i < n; i ++) {
            sum += nums[i];
            int target = sum - k;
            if (sumCount.containsKey(target))
                res += sumCount.get(target);
            sumCount.put(sum, sumCount.getOrDefault(sum ,0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1,1,1}, 4));
    }
}
