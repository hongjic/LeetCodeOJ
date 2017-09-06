package T90;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution2 {

	private void generate(List<List<Integer>> res, int[] nums, List<Integer> index, List<Integer> count, int dep, int[] cur) {
		if (dep == index.size()) {
			List<Integer> set = new ArrayList<Integer>();
			for (int i = 0; i < cur.length; i ++)
				for (int j = 0; j < cur[i]; j ++)
					set.add(nums[index.get(i)]);
			res.add(set);
			return;
		}
		for (int i = 0; i <= count.get(dep); i ++) {
			cur[dep] = i;
			generate(res, nums, index, count, dep + 1, cur);
		}
	}
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<Integer> index = new ArrayList<Integer>();
		List<Integer> count = new ArrayList<Integer>();
		// map  number to distinct index
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i ++) {
			if (map.containsKey(nums[i])) {
				int di = map.get(nums[i]);
				count.set(di, count.get(di) + 1);
			}
			else {
				map.put(nums[i], index.size());
				index.add(i); count.add(1);
			}
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		generate(res, nums, index, count, 0, new int[index.size()]);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,2,2};
		List<List<Integer>> res = new Solution().subsetsWithDup(nums);
		for (int i = 0; i < res.size(); i ++) {
			for (int j = 0; j < res.get(i).size(); j ++)
				System.out.print(res.get(i).get(j));
			System.out.println();
		}
	}

}
