package T190;

public class Solution {

    public int reverseBits(int n) {
        int res = 0, count = 0;
        while (count < 32) {
            res = ((res << 1) | (n & 1));
            n >>= 1;
            count ++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
    }
}
