package T454;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	// complexity O(n^2)
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int len = A.length;
		int[] AB = sumTwoArray(A, B, len);
		int[] CD = sumTwoArray(C, D, len);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < len * len; i ++)
			map.put(CD[i], map.getOrDefault(CD[i], 0) + 1);
		int res = 0;
		for (int i = 0; i < len * len; i ++)
			if (map.containsKey(0 - AB[i])) 
				res += map.get(0 - AB[i]);
		return res;
	}
	
	private int[] sumTwoArray(int[] a, int[] b, int len) {
		int[] res = new int[len * len];
		for (int i = 0; i < len; i ++)
			for (int j = 0; j < len; j ++)
				res[i * len + j] = a[i] + b[j];
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2};
		int[] B = {-2, -1};
		int[] C = {-1, 2};
		int[] D = {0, 2};
		System.out.println(new Solution().fourSumCount(A, B, C, D));
	}

}
