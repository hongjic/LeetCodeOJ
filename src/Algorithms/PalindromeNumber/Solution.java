package Algorithms.PalindromeNumber;


public class Solution {

	private static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int left = 1, right = 1;
        while (x / left >= 10) 
        	left = left * 10;
        while (left > right) {
            int value_l = x / left % 10;
            int value_r = x / right % 10;
            if (value_l != value_r) return false;
            left = left / 10;
            right = right * 10;
        }
        return true;
    }

	public static void main(String[] args) {
		int x = 131;
		System.out.println(isPalindrome(x));

	}

}
