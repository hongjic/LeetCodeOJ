package T371;

public class Solution {

    /*
    https://ych0112xzz.github.io/2016/10/27/OperationwithBits/
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSum(-4, 2));
    }
}
