package T667;

import java.util.*;

public class Solution {

    private static class Result {
        boolean found;
        int[] res;
        public Result(boolean f, int[] r) {
            found = f; res = r;
        }
    }

    private int n, k;

    private Result findArray(Set<Integer> abs, List<Integer> curList, boolean[] used, int index) {
        if (index == n) {
            // finished
            if (abs.size() != k)
                return new Result(false, null);
            int[] list = new int[n];
            for (int i = 0; i < n; i ++)
                list[i] = curList.get(i);
            return new Result(true, list);
        }
        for (int i = 1; i <= n; i ++) {
            int diff = 0;
            if (index != 0)
                diff = Math.abs(curList.get(index - 1) - i);
            if (!used[i] && (index == 0 || (abs.size() < k) || (abs.contains(diff) && abs.size() == k))) {
                curList.add(i); used[i] = true;
                if (index != 0) abs.add(diff);
                Result res = findArray(abs, curList, used, index + 1);
                if (res.found) return res;
                curList.remove(index); used[i] = false;
                if (index != 0) abs.remove(diff);
            }
        }
        return new Result(false, null);
    }

    public int[] constructArray2(int n, int k) {
        this.n = n;
        this.k = k;
        Result res = findArray(new HashSet<>(), new ArrayList<>(), new boolean[n + 1], 0);
        return res.res;
    }

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int i;
        for (i = 0; i < n - k; i ++){
            res[i] = i + 1;
        }
        int right = n, left = n - k + 1;
        boolean chooseRight = true;
        while (i < n) {
            if (chooseRight)
                res[i ++] = right --;
            else
                res[i ++] = left ++;
            chooseRight = !chooseRight;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res= new Solution().constructArray(2, 1);
        for (int a: res) {
            System.out.println(a);
        }
    }
}
