package T668;

public class Solution {

    public int findKthNumber(int m, int n, int k) {
        int min = 1, max = m * n + 1;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int c = count(m, n, mid);
            if (c >= k) max = mid;
            else min = mid + 1;
        }
        return min;
    }

    /*
    count the number of integers no bigger than `mid`
     */
    private int count(int m, int n, int mid) {
        int count = 0;
        for (int i = 1; i <= m; i ++)
            count += Math.min(n, mid/ i);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthNumber(3, 3, 5));
    }
}
