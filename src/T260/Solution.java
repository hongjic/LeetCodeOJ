package T260;

public class Solution {

    public int[] singleNumber(int[] nums) {
        int ones = 0;
        for (int num: nums)
            ones ^= num;

        int diff = 1; // diff is one of the bit the two elements differ
        while ((ones & 1) == 0) {
            diff <<= 1;
            ones >>= 1;
        }

        // divide the array into two parts, make sure the two elements are not together.

        int[] res = new int[]{0, 0};
        for (int num: nums) {
            if ((num & diff) == 0)
            res[0] ^= num;
            else
            res[1] ^= num;
            }
            return res;
            }

public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{1,2,1,3,2,5}));
        }
        }
