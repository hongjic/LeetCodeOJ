package T137;

public class Solution {

    /*
    all 3 times, except one 1 time.
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

    /*
    all 4 times, except one 1 time.
     */
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < nums.length; i ++) {
            ones = (ones ^ nums[i]) & ~twos & ~threes;
            twos = (twos ^ nums[i]) & ~ones & ~threes;
            threes = (threes ^ nums[i]) & ~ones & ~twos;
        }
        return ones;
    }

    /*
    all 3 times, except one 2 times.
     */
    public int singleNumber3(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return twos;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.singleNumber(new int[]{1, 1, 3, 2, 2, 1, 4, 4, 4, 2}));
        System.out.println(sol.singleNumber2(new int[]{1, 1, 1, 3, 2, 2, 1, 4, 4, 4, 4, 2, 2}));
        System.out.println(sol.singleNumber3(new int[]{1, 1, 3, 2, 2, 1, 4, 4, 4, 2, 3}));
    }
}