package T101_end;

import java.util.Map;
import java.util.HashMap;

public class T325 {
	
	public int maxSubArrayLen(int[] nums, int k) {
		int max = 0;
		if (nums == null) return 0;
		int len = nums.length;
		int[] sum = new int[len + 1];
		sum[0] = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		for (int i = 1; i < len + 1; i ++) {
			sum[i] = sum[i - 1] + nums[i - 1];
			if (!map.containsKey(sum[i]))
				map.put(sum[i], i);
		}
		for (int j = 1; j < len + 1; j ++) {
			int need = sum[j] - k;
			if (map.containsKey(need)) {
				int i = map.get(need);
				if (j - i > max)
					max = j - i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T325 t325 = new T325();
		int[] nums = {1, -1, 5, -2, 3};
		int k = 3;
		System.out.println(t325.maxSubArrayLen(nums, k));
	}

}