package T12_56;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class T39 {

	private static void backtracking(List<List<Integer>> res, int target, int[] candidate, int index, List<Integer> cur) {
		if (target==0) {
			res.add(cur);
			return;
		}
		if (index==candidate.length) 
			return;
		int max_times = target/candidate[index];
		if (max_times==0) 
			return;
		for (int times = max_times; times>=0; times--) {
			List<Integer> next = new ArrayList<Integer>();
			next.addAll(cur);
			for (int i=0; i<times; i++)
				next.add(candidate[index]);
			backtracking(res, target-candidate[index]*times, candidate, index+1, next);
		}
	}
	
	private static List<List<Integer>> combinationSum(int[] candidate, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidate);
		int len = candidate.length;
		if (len==0)
			return new ArrayList<List<Integer>>();
		// remove duplicate numbers
		int j=1,i=0;
		while (j<len) {
			while (j<len && candidate[j]==candidate[i]) j++;
			if (j==len) break;
			i++;
			candidate[i] = candidate[j];
			j++;
		}
		candidate = Arrays.copyOfRange(candidate, 0, i+1);
		backtracking(res, target, candidate, 0, new ArrayList<Integer>());
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidate = {2,3,6,7};
		int target = 7;
		List<List<Integer>> res = combinationSum(candidate, target);
		for (int i=0; i<res.size(); i++) {
			for (int j=0; j<res.get(i).size(); j++)
				System.out.println(res.get(i).get(j)+" ");
			System.out.println();
		}
	}

}
//public class Solution {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        int len = candidates.length;
//
//        List<List<Integer>> result = new LinkedList<List<Integer>>();
//
//        addList(result,new LinkedList<Integer>(), candidates, target, 0);
//
//        return result;
//    }
//
//    public void addList (List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int index) {
//        for(int i=index;i<candidates.length;i++) {
//            if(candidates[i] < target) {
//                List<Integer> list = new LinkedList<Integer>();
//                list.addAll(cur);
//                list.add(candidates[i]);
//                addList(result, list, candidates, target - candidates[i], i);
//            } else if (candidates[i] == target) {
//                List<Integer> list = new LinkedList<Integer>();
//                list.addAll(cur);
//                list.add(candidates[i]);
//                result.add(list);
//            } else {
//                break;
//            }
//        }
//    }
//}