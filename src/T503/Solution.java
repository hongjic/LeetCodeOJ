package T503;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // key: the index of the number, value: the index of the next greater element
    private Map<Integer, Integer> map = new HashMap<>();

    // return the index of the next greater elemnt of nums[index]
    private int nextGreaterElement(int[] nums, int index) {
        if (map.containsKey(index)) return map.get(index);

        int next = (index + 1) % nums.length;
        while (next != index && nums[next] <= nums[index])
            next = nextGreaterElement(nums, next);

        map.put(index, next);
        return next;
    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length];

        int max = nums[0], pos = 0;
        for (int i = 1; i < nums.length; i ++) max = Math.max(max, nums[i]);
        for (int i = 0; i < nums.length; i ++)
            if (max == nums[i]) {
                map.put(i, -1);
                pos = i;
            }

        // start from the max number, iterate reversely to avoid stackoverflow.
        for (int i = pos; i > pos - nums.length; i --) {
            int index = (i + nums.length) % nums.length;
            int nextIndex = nextGreaterElement(nums, index);
            if (nextIndex == -1) res[index] = -1;
            else res[index] = nums[nextIndex];
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().nextGreaterElements(new int[] {2,1,2});
    }
}
