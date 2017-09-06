package T476;

public class Solution {

	// Weekly Contest 14: Number Complement 
	public int findComplement(int num) {
		long i = 2;
		while (i <= num) i *= 2;
		return (int)(i - 1 - num);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().findComplement(8));
	}

}