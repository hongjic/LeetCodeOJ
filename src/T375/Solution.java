package T375;


public class Solution {
/*
    dynamic programming
    f[i]: minimum pay to guarantee a win when n = i
    O(n * logn)
    Wrong solution
*/
//    public int getMoneyAmount(int n) {
//        if (n == 1) return 0;
//        int[] f = new int[n + 1];
//        for (int i = 2; i <= n; i ++) {
//            int j = 2, sum = 0, min = Integer.MAX_VALUE;
//            while (i >= j && f[i - j] > sum) {
//                sum += i - j + 1;
//                min = Math.min(min, f[i - j] + i - j + 1);
//                j *= 2;
//            }
//            min = Math.min(min, sum + i - j + 1);
//            f[i] = min;
//        }
//        return f[n];
//    }

    private int[][] cache;

    public int getMoneyAmount(int n) {
        cache = new int[n + 1][n + 1];
        return getMoneyAmount(1, n);
    }

    private int getMoneyAmount(int begin, int end) {
        if (begin >= end) return 0;
        if (cache[begin][end] > 0) return cache[begin][end];
        int min = Integer.MAX_VALUE;
        for (int div = begin; div <= end; div ++) {
            min = Math.min(min, div + Math.max(getMoneyAmount(begin, div - 1), getMoneyAmount(div + 1, end)));
        }
        cache[begin][end] = min;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(124));
    }
}
