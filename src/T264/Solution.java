package T264;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	// O(nlogn)
	public int nthUglyNumber(int n) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for (int i = 1; i < n; i ++) {
			long t2 = findNextMin(list, 2);
			long t3 = findNextMin(list, 3);
			long t5 = findNextMin(list, 5);
			list.add((int)Math.min(t2, Math.min(t3, t5)));
		}
		return list.get(n - 1);
	}
	
	private long findNextMin(List<Integer> list, int times) {
		int left = 0, right = list.size() - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if ((long)list.get(mid) * times > list.get(list.size() - 1)) right = mid;
			else left = mid + 1;
		}
		return (long)list.get(left) * times;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().nthUglyNumber(1559));
	}

}
