package T340;

import java.util.Map;
import java.util.HashMap;


/*
 * dp solution O(nk). the sliding window implementation is much better. O(n)
 */
public class Solution {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0 || k == 0)
			return 0;
		if (s.length() <= k) 
			return s.length();
		int len = s.length();
		
		int[] dup = new int[len];
		Map<Character, Integer> last = new HashMap<Character, Integer>();
		for (int i = 0; i < len; i ++) {
			if (last.containsKey(s.charAt(i))) 
				dup[i] = last.get(s.charAt(i));
			else
				dup[i] = -1;
			last.put(s.charAt(i), i);
		}
		
		int max = 0;
		int[][] f = new int[len][k + 1];
		f[0][0] = 0;
		f[0][1] = 1;
		
		for (int i = 1; i < len; i ++) {
			for (int j = 1; j <= k; j ++) {
				if (i - f[i - 1][j] > dup[i])
					f[i][j] = f[i - 1][j - 1] + 1;
				else
					f[i][j] = f[i - 1][j] + 1;
				max = Math.max(max, f[i][j]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().lengthOfLongestSubstringKDistinct("eceba", 2));
	}

}
