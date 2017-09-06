package T89;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	
	// a much better mathematical solution: https://en.wikipedia.org/wiki/Gray_code
	// R(i) = i ^ (i << 1);
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		for (int i = 0; i < n; i ++) {
			int size = res.size(), base = 1 << i;
			for (int j = size - 1; j >= 0; j --)
				res.add(base + res.get(j));
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = new Solution().grayCode(20);
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i) + ", ");
	}

}
