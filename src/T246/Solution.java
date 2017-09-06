package T246;

public class Solution {

	public boolean isStrobogrammatic(String num) {
		int len = num.length();
		for (int i = 0; i < len / 2 + 1; i ++) {
			int left = num.charAt(i) - 48;
			int right = num.charAt(len - 1 - i) - 48;
			if (left == 0 && right == 0) continue;
			if (left == 1 && right == 1) continue;
			if (left == 8 && right == 8) continue;
			if (left == 6 && right == 9) continue;
			if (left == 9 && right == 6) continue;
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isStrobogrammatic("8160618"));
	}

}
