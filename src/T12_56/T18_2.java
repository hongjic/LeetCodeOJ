package T12_56;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

public class T18_2 {
	
	public static class PairSum {
		int first;
		int second;
		int sum;
	}
	
	private boolean noCommon(PairSum a, PairSum b) {
		if (a.first == b.first || a.first == b.second || a.second == b.first || a.second == b.second)
			return false;
		return true;
	}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		int n = nums.length;
		int size = n * (n - 1) / 2;
		PairSum[] aux = new PairSum[size];
		int k = 0;
		for (int i = 0; i < n - 1; i ++)
			for (int j = i + 1; j < n; j ++) {
				aux[k] = new PairSum();
				aux[k].first = i;
				aux[k].second = j;
				aux[k].sum = nums[i] + nums[j];
				k ++;
			}
		
		Arrays.sort(aux, new Comparator<PairSum>() {
			@Override
			public int compare(PairSum a, PairSum b) {
				return a.sum - b.sum;
			}
		});
		Set<List<Integer>> results = new HashSet<List<Integer>>();
		
		int i = 0, j = size - 1;
		while (i < size && j >= 0) {
			if (aux[i].sum + aux[j].sum == target && noCommon(aux[i], aux[j])) {
				List<Integer> result = Arrays.asList(nums[aux[i].first], nums[aux[i].second], nums[aux[j].first], nums[aux[j].second]);
				Collections.sort(result);
				results.add(result);
				i ++; 
			}
			else if (aux[i].sum + aux[j].sum < target)
				i ++;
			else j --;
		}
		
		return new ArrayList<List<Integer>>(results);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T18_2 sol = new T18_2();
		int target = 0;
		int[] nums = new int[] {1,2,3,4,-1,-2,-3,-4};
		List<List<Integer>> results = sol.fourSum(nums, target);
		for (int i = 0; i < results.size(); i ++) {
			for (int j = 0; j < results.get(i).size(); j ++)
				System.out.print(results.get(i).get(j) + " ");
			System.out.println();
		}
	}

}