package T12_56;

import java.util.ArrayList;
import java.util.List;


public class T46 {

	private void helper(int[] nums, List<List<Integer>> res, boolean[] f, List<Integer> order) {
		if (order.size()==nums.length) {
			List<Integer> ans = new ArrayList<Integer>();
			for (int i=0; i<order.size(); i++)
				ans.add(nums[order.get(i)]);
			res.add(ans);
			return;
		}
		for (int i=0; i<f.length; i++)
			if (!f[i]) {
				f[i] = true;
				order.add(i);
				helper(nums, res, f, order);
				f[i] = false;
				order.remove(order.size()-1);
			}
	}
	
	public List<List<Integer>> permute(int[] nums) {
		int len = nums.length;
		if (len==0) 
			return new ArrayList<List<Integer>>();
		boolean[] f = new boolean[len];
		List<Integer> order = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(nums, res, f, order);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T46 t46 = new T46();
		int[] nums = {1,2,3};
		List<List<Integer>> res = t46.permute(nums);
		for (int i=0; i<res.size(); i++) {
			for (int j=0; j<res.get(i).size(); j++)
				System.out.print(res.get(i).get(j));
			System.out.println();
		}
	}

}








//public class Solution {
//    public List<List<Integer>> permute(int[] nums) {
//    List<List<Integer>> list = new ArrayList<>();
//    if(nums == null || nums.length == 0 ) return list;
//    backtrack(list, new ArrayList<>(), nums);
//    return list;
//}
//
//private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
//    if(tempList.size() == nums.length){
//        list.add(new ArrayList<>(tempList));
//    } else{
//        for(int i = 0; i <= tempList.size(); i++){
//            tempList.add(i, nums[tempList.size()]);
//            backtrack(list, tempList, nums);
//            tempList.remove(i);
//        } 
//    }
//}
//}