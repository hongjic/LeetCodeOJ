package T120;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public int minimumTotal(List<List<Integer>> triangle) {
		int h = triangle.size(), w = h;
		if (h == 0) return 0;
		int[] sum = new int[w];
		sum[0] = triangle.get(0).get(0);
		for (int i = 1; i < h; i ++) {
			sum[i] = sum[i - 1] + triangle.get(i).get(i);
			for (int j = i - 1; j >= 1; j --)
				sum[j] = Math.min(sum[j], sum[j - 1]) + triangle.get(i).get(j);
			sum[0] = sum[0] + triangle.get(i).get(0);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < w; i ++)
			min = Math.min(min, sum[i]);
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3,4));
		triangle.add(Arrays.asList(6,5,7));
		triangle.add(Arrays.asList(4,1,8,3));
		System.out.println(new Solution().minimumTotal(triangle));
	}

}
