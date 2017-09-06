package T204;

import java.util.Arrays;

public class Solution {

	public int countPrimes(int n) {
		boolean[] prime = new boolean[n];
		Arrays.fill(prime, true);
		int p = 2, sum = 0;
		while (p < n) {
			int nn = p * 2;
			while (nn < n) {
				prime[nn] = false;
				nn += p;
			}
			p ++;
			while (p < n && prime[p] == false) p ++;
			sum ++;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().countPrimes(10));
	}

}
