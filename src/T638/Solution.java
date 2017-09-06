package T638;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        for (int i = n; i < 6; i ++) {
            needs.add(0);
            price.add(0);
        }

        for (int i = 0; i < special.size(); i ++) {
            int p = special.get(i).get(n);
            special.get(i).set(n, 0);
            for (int j = n + 1; j < 7; j ++)
                special.get(i).add(0);
            special.get(i).set(6, p);
        }

        int[][][][][][] dp = new int[7][7][7][7][7][7];
        for (int i1 = 0; i1 < 7; i1 ++)
        for (int i2 = 0; i2 < 7; i2 ++)
        for (int i3 = 0; i3 < 7; i3 ++)
        for (int i4 = 0; i4 < 7; i4 ++)
        for (int i5 = 0; i5 < 7; i5 ++)
        for (int i6 = 0; i6 < 7; i6 ++)
            dp[i1][i2][i3][i4][i5][i6] = price.get(0) * i1 + price.get(1) * i2 + price.get(2) * i3 + price.get(3) * i4
                    + price.get(4) * i5 + price.get(5) * i6;

        for (int i = 0; i < special.size(); i ++)
        for (int c0 = special.get(i).get(0); c0 <= needs.get(0); c0 ++)
        for (int c1 = special.get(i).get(1); c1 <= needs.get(1); c1 ++)
        for (int c2 = special.get(i).get(2); c2 <= needs.get(2); c2 ++)
        for (int c3 = special.get(i).get(3); c3 <= needs.get(3); c3 ++)
        for (int c4 = special.get(i).get(4); c4 <= needs.get(4); c4 ++)
        for (int c5 = special.get(i).get(5); c5 <= needs.get(5); c5 ++) {

            dp[c0][c1][c2][c3][c4][c5] = Math.min(dp[c0][c1][c2][c3][c4][c5],
                    dp[c0 - special.get(i).get(0)][c1 - special.get(i).get(1)][c2 - special.get(i).get(2)][c3 - special.get(i).get(3)][c4 - special.get(i).get(4)][c5 - special.get(i).get(5)] + special.get(i).get(6));
        }

        return dp[needs.get(0)][needs.get(1)][needs.get(2)][needs.get(3)][needs.get(4)][needs.get(5)];
    }

    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>(Arrays.asList(4, 3, 2, 9, 8, 8));
        List<List<Integer>> special = new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1,5,5,1,4,0,18)), new ArrayList<>(Arrays.asList(3,3,6,6,4,2,32))));
        List<Integer> needs = new ArrayList<>(Arrays.asList(6,5,5,6,4,1 ));
        System.out.println(new Solution().shoppingOffers(price, special, needs));
    }
}