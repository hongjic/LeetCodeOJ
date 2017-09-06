package T231;

public class Solution {

	public boolean isPowerOfTwo(int n) {
		if (n <= 0) return false;
		while (n >= 2) {
			if ((n & 1) == 1) return false;
			n = n >> 1;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isPowerOfTwo(6));
	}

}
