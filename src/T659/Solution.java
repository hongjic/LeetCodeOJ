package T659;

import java.util.*;

public class Solution {

    public boolean isPossible(int[] nums) {
        int n = nums.length, i = 0;
        int p1 = 0, p2 = 0, p3 = 0;
        Integer pre = null;
        while (i < n) {
            int num = nums[i ++], freq = 1;
            while (i < n && nums[i] == num) {
                i ++; freq ++;
            }
            if (pre == null) {
                p1 = freq; p2 = 0; p3 = 0;
            }
            else if (num > pre + 1) {
                if (p1 > 0 || p2 > 0) return false;
                p1 = freq; p2 = 0; p3 = 0;
            }
            else {  // num == pre + 1
                if (freq < p1 + p2) return false;
                int c2 = p1, c3 = p2 + Math.min(p3, freq - p1 - p2);
                int c1 = Math.max(0, freq - p1 - p2 - p3);
                p1 = c1; p2 = c2; p3 = c3;
            }
            pre = num;
        }
        if (p1 == 0 && p2 == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPossible(new int[] {1,2,3,4,4,5,5}));
    }
}
