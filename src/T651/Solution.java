package T651;

import java.util.*;

/*
In each step, `pairs` persists possible results of (buffer, numA)
 */
public class Solution {

    public int maxA(int N) {
        int[] f = new int[N + 1];
        LinkedList<int[]> pairs = new LinkedList<>();
        pairs.add(new int[]{0, 0});  //N = 0;
        for (int i = 1; i <= N; i ++) {
            LinkedList<int[]> newPairs = new LinkedList<>();
            for (int[] pair: pairs) {
                int[] newPair = new int[] {pair[0], pair[1] + Math.max(pair[0], 1)};
                newPairs.add(newPair);
            }
            if (i >= 4)
                newPairs.add(new int[] {f[i - 3], f[i - 3] * 2});
            // copy `newPairs` backto pairs
            pairs.clear();
            Iterator<int[]> iter = newPairs.descendingIterator();
            while (iter.hasNext()) {
                int[] pair = iter.next();
                if (pairs.isEmpty() || pairs.getFirst()[1] < pair[1]) {
                    pairs.addFirst(pair);
                    f[i] = Math.max(f[i], pair[1]);
                }
            }
        }

        return f[N];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxA(50));
    }
}
