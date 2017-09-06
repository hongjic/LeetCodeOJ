/**
 * 
 */
package T12_56;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

/**
 * @author chenhongji
 *
 */
public class T15_2 {

	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		if (nums == null || nums.length == 0)
			return new ArrayList<List<Integer>>(result);
		Arrays.sort(nums);
		int len = nums.length;
		
		
		return new ArrayList<List<Integer>>(result);
	}
	
	public static void main(String[] args) {
		T15_2 t15 = new T15_2();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result = t15.threeSum(nums);
		for (int i = 0; i < result.size(); ++ i) {
			List<Integer> resultItem = result.get(i);
			for (int j = 0; j < resultItem.size(); ++ j)
				System.out.print(resultItem.get(j) + " ");
			System.out.println();
		}

	}

}
