package T135;

import java.util.Arrays;

/**
 * Created by chenhongji on 2017/8/3.
 */
public class Solution {

    private void fill(int[] arr, int index, int value) {
        if (value > arr[index]) arr[index] = value;
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;

        int j = 1, i = 0;
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);

        while (j < ratings.length) {
            if (ratings[j] == ratings[i]) {
                fill(arr, i, 1);
                fill(arr, j, 1);
                j ++; i ++;
            }
            else if (ratings[j] > ratings[i]) {
                while (j < ratings.length && ratings[j] > ratings[j - 1]) j ++;
                // from i to j - 1
                for (int k = i; k < j; k ++)
                    fill(arr, k, k - i + 1);
                i = j - 1;
            }
            else {
                while (j < ratings.length && ratings[j] < ratings[j - 1]) j ++;
                // from j - 1 to i
                for (int k = j - 1; k >= i; k --)
                    fill(arr, k, j - k);
                i = j - 1;
            }
        }
        int sum = 0;
        for (i = 0; i < ratings.length; i ++)
            sum += arr[i];
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{3,2,3,2,0,-1,3,2,4}));
    }
}
