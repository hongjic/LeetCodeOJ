package T12_56;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class T47 {

	private void helper(int[] nums, List<List<Integer>> res, int[] f, List<Integer> order, int len) {
		if (order.size()==len) {
			List<Integer> ans = new ArrayList<Integer>();
			for (int i=0; i<order.size(); i++)
				ans.add(nums[order.get(i)]);
			res.add(ans);
			return;
		}
		for (int i=0; i<f.length; i++)
			if (f[i]>0) {
				f[i]--;order.add(i);
				helper(nums, res, f, order, len);
				f[i]++;order.remove(order.size()-1);
			}
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		int len = nums.length;
		if (len==0) 
			return new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int[] f = new int[len];
		int i=0,j=0;
		while (j<nums.length) {
			f[i] = j;
			while (j<nums.length && nums[i]==nums[j]) j++;
			f[i] = j-f[i];
			if (j==nums.length) break;
			i++;
			nums[i] = nums[j];
		}
		nums = Arrays.copyOf(nums, i+1);
		List<Integer> order = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(nums, res, f, order, len);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T47 t47 = new T47();
		int[] nums = {1,1,2,3};
		List<List<Integer>> res = t47.permuteUnique(nums);
		for (int i=0; i<res.size(); i++) {
			for (int j=0; j<res.get(i).size(); j++)
				System.out.print(res.get(i).get(j));
			System.out.println();
		}
	}

}













//public class Solution {
//    public List<List<Integer>> permuteUnique(int[] nums) {
//    boolean[] visited = new boolean[nums.length];
//    Arrays.sort(nums);
//    List<List<Integer>> ret = new ArrayList<>();
//    dfs(nums, visited, new ArrayList<>(), ret);
//    return ret;
//}
//
//private void dfs(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> ret) {
//    if (path.size() == nums.length) {
//        ret.add(path);
//        return;
//    }
//    for (int i = 0; i < nums.length; i++) {
//        if (visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) {
//            continue;   // remove duplicates
//        }
//        List<Integer> p = new ArrayList<>(path);
//        p.add(nums[i]);
//        visited[i] = true;
//        dfs(nums, visited, p, ret);
//        visited[i] = false;  // recover
//    }
//}
//}