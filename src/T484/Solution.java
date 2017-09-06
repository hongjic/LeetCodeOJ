package T484;

public class Solution {

	// time complexity: O(n)
	public int[] findPermutation(String s) {
		int len = s.length();
		int[] res = new int[len + 1];
		res[0] = 1;
		int i = 0;
		while (i < len) {
			if (s.charAt(i) == 'I') {
				res[i + 1] = i + 2;
				i ++;
			}
			else {
				int count = 0, start = res[i];
				while (i < len && s.charAt(i) == 'D') {
					count ++; i ++;
				}
				for (int j = i; j >= i - count; j --) 
					res[j] = start ++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] res = new Solution().findPermutation("DIDDIDIIDDD");
		for (int i = 0; i < res.length; i ++)
			System.out.print(res[i] + ", ");
	}

}
