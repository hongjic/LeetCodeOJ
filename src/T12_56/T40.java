package T12_56;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class T40 {

	private static void helper(Set<List<Integer>> res, int[] candidates, int target, boolean[] f, int index) {
		if (target == 0) {
			List<Integer> solution = new ArrayList<Integer>();
			for (int i=0; i<f.length; i++)
				if (f[i]) solution.add(candidates[i]);
			res.add(solution);
			return;
		}
		if (index == candidates.length || candidates[index]>target)
			return;
		for (int i=index; i<candidates.length; i++) {
			if (i>index && candidates[i]==candidates[i-1])
				continue;
			f[i] = true;
			helper(res, candidates, target-candidates[i], f, i+1);
			f[i] = false;
		}
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		int len = candidates.length;
		if (len==0) 
			return new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		boolean[] f = new boolean[len];
		helper(res, candidates, target, f, 0);
		return new ArrayList<List<Integer>>(res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> res = combinationSum2(candidates, target);
		for (int i=0; i<res.size(); i++) {
			for (int j=0; j<res.get(i).size(); j++)
				System.out.print(res.get(i).get(j)+" ");
			System.out.println();
		}
	}

}





//public class Solution {
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//    Arrays.sort(candidates);
//    List<List<Integer>> ret = new ArrayList<>();
//    dfs(candidates, target, 0, new ArrayList<>(), ret);
//    return ret;
//}
//
//private void dfs(int[] nums, int target, int idx, List<Integer> path, List<List<Integer>> ret) {
//    if (target <= 0) {
//        if (target == 0) {
//            ret.add(path);
//        }
//        return; // backtracking
//    }
//    for (int i = idx; i < nums.length; i++) {
//        if (i > idx && nums[i] == nums[i-1]) {
//            continue;
//        }
//        List<Integer> p = new ArrayList<>(path);
//        p.add(nums[i]);
//        dfs(nums, target-nums[i], i+1, p, ret);
//    }
//}
//}