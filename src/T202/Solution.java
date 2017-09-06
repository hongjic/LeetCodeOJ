package T202;

import java.util.Set;
import java.util.HashSet;

public class Solution {

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while (!set.contains(n) && n != 1) {
			set.add(n);
			n = next(n);
		}
		if (n == 1) return true;
		return false;
	}
	
	private int next(int n) {
		int sum = 0;
		while (n > 0) {
			sum += (n % 10) * (n % 10);
			n = n / 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isHappy(20));
	}

}
