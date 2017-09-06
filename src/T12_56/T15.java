package T12_56;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class T15 {
	private static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		List<Integer> nnums = new ArrayList<Integer>();
		//count the frequency
		for (int i=0; i<nums.length; i++)
			if (map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i])+1);
			else {
				map.put(nums[i], 1);
				nnums.add(nums[i]);
			}
		//find triplet that have no duplicate numbers
		Collections.sort(nnums);
		for (int i=0; i<nnums.size()-2; i++)
			for (int j=i+1; j<nnums.size()-1; j++) 
				if (nnums.get(i)<nnums.get(j)) {
					int k = 0-nnums.get(i)-nnums.get(j);
					if (map.containsKey(k) && k>nnums.get(j)) {
						LinkedList<Integer> triplet = new LinkedList<Integer>();
						triplet.addLast(nnums.get(i));
						triplet.addLast(nnums.get(j));
						triplet.addLast(k);
						res.add(triplet);
					}
				}
		//Search for triplets where two numbers are equal        
        for (int i = 0; i<nnums.size(); i++) {
            int firstAndSecond = nnums.get(i);
            //Must have at least two occurrences 
            if (map.get(firstAndSecond) <= 1) continue;
            //Prevent the case when there are only two 0s!
            if (firstAndSecond == 0) continue;
            int third = 0 - firstAndSecond - firstAndSecond;
            if (map.containsKey(third)) {
            	LinkedList<Integer> triplet = new LinkedList<Integer>();
            	triplet.addLast(firstAndSecond);
            	triplet.addLast(firstAndSecond);
                if (third > firstAndSecond)
                	triplet.addLast(third);
                else 
                    triplet.addFirst(third);
                res.add(triplet);
            }
        }
        //0,0,0
        if (map.containsKey(0) && map.get(0) >= 3) res.add(Arrays.asList(0, 0, 0));
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];
		for (int i=0; i<n; i++) 
			nums[i] = scanner.nextInt();
		//outprint;
		List<List<Integer>> ans = threeSum(nums);
		for (int i=0; i<ans.size(); i++) {
			for (int j=0; j<ans.get(i).size(); j++)
				System.out.print(ans.get(i).get(j)+", ");
			System.out.println();
		}
	}
}