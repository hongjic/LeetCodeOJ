package T397;

public class Solution {

    public int integerReplacement(int n) {
        if (n == 1) return 0;
        int count = 0;
        if ((n & 1) == 0) {
            while ((n & 1) == 0) {
                n >>= 1;
                count ++;
            }
            return integerReplacement(n) + count;
        }
        if ((n & 3) == 3 && n > 3) {
            while ((n & 1) == 1) {
                n >>= 1;
                count ++;
            }
            n |= 1;
            return integerReplacement(n) + count + 1;
        }
        return integerReplacement(n - 1) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerReplacement(7));
    }
}
