package T556;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int nextGeneraterElement(int n) {
        List<Integer> tail = new ArrayList<>();
        int t = 0;
        while (n > 0 && n % 10 >= t) {
            t = n % 10;
            tail.add(t);
            n = n / 10;
        }
        if (n == 0) return -1;

        int target = n % 10;
        int bm = tail.get(tail.size() - 1), pos = tail.size() - 1;
        for (int i = tail.size() - 2; i >= 0; i --)
            if (tail.get(i) <= target) break;
            else {
                bm = tail.get(i);
                pos = i;
            }

        long next = n - target + bm;
        tail.set(pos, target);
        Collections.sort(tail);
        for (int num: tail)
            next = next * 10 + num;

        if (next <= Integer.MAX_VALUE) return (int)next;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nextGeneraterElement(12));
        System.out.println(new Solution().nextGeneraterElement(987653421));
        System.out.println(new Solution().nextGeneraterElement(59130020));
        System.out.println(new Solution().nextGeneraterElement(1999999999));
    }
}
