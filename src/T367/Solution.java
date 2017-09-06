package T367;

public class Solution {

	public boolean isPerfectSquare(int num) {
		if (num == 0) return false;
		int left = 0, right = num;
		while (left < right) {
			int mid = (left + right) / 2;
			long m = (long)mid * mid;
			if (m == num) return true;
			if (m > num) right = mid;
			else left = mid + 1;
		}
		if (left * left == num) return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.isPerfectSquare(2147483647));
	}

}
