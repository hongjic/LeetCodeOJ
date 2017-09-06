package T496;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // key: the number, value: the index of the next greater number in nums2
        if (nums1.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums2[nums2.length - 1], -1);

        for (int i = nums2.length - 2; i >= 0; i --)
            if (nums2[i + 1] > nums2[i]) map.put(nums2[i], i + 1);
            else {
                int nextIndex = map.get(nums2[i + 1]);
                while (nextIndex != -1 && nums2[nextIndex] < nums2[i])
                    nextIndex = map.get(nums2[nextIndex]);
                map.put(nums2[i], nextIndex);
            }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i ++) {
            int index = map.get(nums1[i]);
            if (index == -1) res[i] = -1;
            else res[i] = nums2[map.get(nums1[i])];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution().nextGreaterElement(new int[] {2,4}, new int[] {1,2,3,4});
        for (int i = 0; i < res.length; i ++)
            System.out.println(res[i]);
    }

}
