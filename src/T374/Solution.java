package T374;

public class Solution{
	
	private int v;
	
	public Solution(int x) {
		v = x;
	}
	
	private int guess(int num) {
		if (num < v) return -1;
		if (num > v) return 1;
		return 0;
	}
	
	public int guessNumber(int n) {
		int left = 1, right = n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (guess(mid) == 0) return mid;
			if (guess(mid) == -1) right = mid - 1;
			if (guess(mid) == 1) left = mid + 1;
		}
		return left;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution(10).guessNumber(6));
	}
}
