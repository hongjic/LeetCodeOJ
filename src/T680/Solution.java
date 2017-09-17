package T680;

public class Solution {

    public boolean validPalindrome(String s) {
        return validPalindrome(s, 1);
    }

    private boolean validPalindrome(String s, int count) {
        int len = s.length();
        for (int i = 0; i < len / 2; i ++)
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                if (count == 0) return false;
                else {
                    return validPalindrome(s.substring(i + 1, len - i), 0) || validPalindrome(s.substring(i, len - i - 1), 0);
                }
            }
        return true;
    }

    public static void main(String[] args){
        System.out.println(new Solution().validPalindrome("abddbca"));
        System.out.println(new Solution().validPalindrome("abba"));
        System.out.println(new Solution().validPalindrome("a"));
        System.out.println(new Solution().validPalindrome("abbac"));
        System.out.println(new Solution().validPalindrome("abca"));
        System.out.println(new Solution().validPalindrome("abbdda"));

    }
}
