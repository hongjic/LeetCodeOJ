package T670;

import java.util.*;

public class Solution {

    private List<Integer> toArray(int num) {
        LinkedList<Integer> res = new LinkedList<>();
        while (num > 0) {
            res.addFirst(num % 10);
            num = num / 10;
        }
        return new ArrayList<Integer>(res);
    }

    private int toNum(List<Integer> arr) {
        int num = 0;
        for (int a: arr) {
            num = num * 10 + a;
        }
        return num;
    }

    public int maximumSwap(int num) {
        List<Integer> arr = toArray(num);
        int len = arr.size();
        int[][] max = new int[len][2];  // max[i] record the max number from i to end

        for (int i = len - 1; i >= 0; i --) {
            if (i == len - 1) {
                max[i][0] = arr.get(i);
                max[i][1] = i;
            }
            else {
                max[i][0] = max[i + 1][0];
                max[i][1] = max[i + 1][1];
                if (arr.get(i) > max[i + 1][0]) {
                    max[i][0] = arr.get(i);
                    max[i][1] = i;
                }
            }
        }

        // check and swap
        for (int i = 0; i < len; i ++) {
            if (arr.get(i) != max[i][0]) {
                int t = arr.get(i);
                arr.set(i, arr.get(max[i][1]));
                arr.set(max[i][1], t);
                break;
            }
        }

        return toNum(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(2736));
    }
}
