package T672;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /*
    n <= 6
     */

    private void flip(int[] op, int amount, int number, Set<Integer> set) {
        if (amount == 0) {
            set.add(number);
            return;
        }
        for (int i = 0; i < 4; i ++)
            flip(op, amount - 1, number ^ op[i], set);
    }

    public int flipLights(int n, int m) {
        if (m == 0) return 1;
        if (n > 6) n = 6;

        int[] op = {63, 42, 21, 9};

        // normalize operation
        int limit = 1, nn = n - 1;
        while (nn > 0) {
            limit = limit * 2 + 1;
            nn --;
        }
        for (int i = 0; i < 4; i ++)
            op[i] = (op[i] & limit);

        Set<Integer> set = new HashSet<>();
        if (m == 1) {
            flip(op, 1, 0, set);
        }
        else if (m == 2) {
            flip(op, 2, 0, set);
            flip(op, 0, 0, set);
        }
        else if (m >= 3 && m % 2 == 1) {
            flip(op, 1, 0, set);
            flip(op, 3, 0, set);
        }
        else {
            flip(op, 0, 0, set);
            flip(op, 2, 0, set);
            flip(op, 4, 0, set);
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().flipLights(3, 1));
    }
}
