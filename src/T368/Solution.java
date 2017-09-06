package T368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        if (nums == null || nums.length == 0) return new ArrayList<>();
//        Arrays.sort(nums);  // input is not ordered.
//        int size = nums.length;
//        boolean[] visited = new boolean[size];
//        List<Integer> res = null;
//        int max = 0;
//        for (int i = size - 1; i >= 0; i --)
//            if (!visited[i]){
//                visited[i] = true;
//                int count = 1;
//                List<Integer> set = new ArrayList<>();
//                set.add(nums[i]);
//                for (int j = i - 1; j >= 0; j --)
//                    if (nums[i] % nums[j] == 0) {
//                        count ++;
//                        set.add(nums[j]);
//                        visited[j] = true;
//                    }
//                if (count > max) {
//                    max = count;
//                    res = set;
//                }
//            }
//        return res;
//    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length, max = 0, maxIndex = 0;
        int[][] f = new int[n][2];  // f[i][0] set size, f[i][1] last element index
        for (int i = 0; i < n; i ++) f[i][1] = -1;

        for (int i = 0; i < n; i ++)
            for (int j = i - 1; j >= 0; j --)
                if (nums[i] % nums[j] == 0 && f[j][0] + 1 > f[i][0]) {
                    f[i][0] = f[j][0] + 1;
                    f[i][1] = j;
                    if (f[i][0] > max) {
                        max = f[i][0];
                        maxIndex = i;
                    }
                }

        LinkedList<Integer> res = new LinkedList<>();
        int index = maxIndex;
        while (index != -1) {
            res.addFirst(nums[index]);
            index = f[index][1];
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new Solution().largestDivisibleSubset(new int[] {});
        for (int r: res)
            System.out.print(r + ", ");
    }
}
