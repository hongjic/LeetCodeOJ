package T12_56;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T18 {
	
//	private static boolean exist(int a, int b, int c, int d, Map<Integer, Integer> freq) {
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		map.put(a, 1);
//		if (map.containsKey(b)) map.put(b, map.get(b)+1);
//		else map.put(b, 1);
//		if (map.containsKey(c)) map.put(c, map.get(c)+1);
//		else map.put(c, 1);
//		if (map.containsKey(d)) map.put(d, map.get(d)+1);
//		else map.put(d, 1);
//		for (Integer key: map.keySet()) 
//			if (map.get(key)>freq.get(key)) 
//				return false;
//		return true;
//	}
//	
//	private static List<Integer> sort(List<Integer> a, List<Integer> b) {
//		int i = 0;
//		int j = 0;
//		List<Integer> res = new ArrayList<Integer>();
//		while (i<a.size() || j<b.size()) {
//			if (i==a.size()) {
//				res.add(b.get(j));
//				j++;continue;
//			}
//			if (j==b.size()) {
//				res.add(a.get(i));
//				i++;continue;
//			}
//			if (a.get(i)<b.get(j)) {
//				res.add(a.get(i));
//				i++;
//			}
//			else {
//				res.add(b.get(j));
//				j++;
//			}
//		}
//		return res;
//	}
//	//this solution should be O(n^2) but actually runs for a long time  dont know why
//	private static List<List<Integer>> fourSum(int[] nums, int target) {
//		Map<Integer, Integer> freq_num = new HashMap<Integer, Integer>();
//		Map<Integer, List<List<Integer>>> pair = new HashMap<Integer, List<List<Integer>>>();
//		Map<Integer, Boolean> isvisited = new HashMap<Integer, Boolean>();
//		Arrays.sort(nums);
//		for (int i=0; i<nums.length; i++)
//			if (freq_num.containsKey(nums[i])) 
//				freq_num.put(nums[i], freq_num.get(nums[i])+1);
//			else
//				freq_num.put(nums[i], 1);
//		for (int i=0; i<nums.length-1; i++)
//			for (int j=i+1; j<nums.length; j++) {
//				if (!pair.containsKey(nums[i]+nums[j])) {
//					List<List<Integer>> value = new ArrayList<List<Integer>>();
//					pair.put(nums[i]+nums[j], value);
//				}
//				pair.get(nums[i]+nums[j]).add(Arrays.asList(nums[i],nums[j]));
//				isvisited.put(nums[i]+nums[j], false);
//			}
//		//match pairs
//		Set<List<Integer>> answers = new HashSet<List<Integer>>();
//		for (Integer sum: pair.keySet()) 
//			if (!isvisited.get(sum)) {
//				int left = target-sum;
//				if (pair.containsKey(left)) {
//					isvisited.replace(sum, true);
//					isvisited.replace(left, true);
//					List<List<Integer>> pairs1 = pair.get(sum), pairs2 = pair.get(left);
//					for (int i=0; i<pairs1.size(); i++)
//						for (int j=0; j<pairs2.size(); j++) 
//							if (exist(pairs1.get(i).get(0), pairs1.get(i).get(1), 
//									pairs2.get(j).get(0), pairs2.get(j).get(1), freq_num))
//								answers.add(sort(pairs1.get(i), pairs2.get(j)));
//				}
//			}
//		
//		return new ArrayList<List<Integer>>(answers);
//	}
	
	private static boolean minor(List<Integer> a, List<Integer> b) {
		for (int i=0; i<4; i++)
			if (a.get(i)<b.get(i))
				return true;
			else if (a.get(i)>b.get(i))
				return false;
		return false;
	}
	
	private static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i=0; i<nums.length-3; i++)
			for (int j=i+1; j<nums.length-2; j++) {
				if (nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target) 
					continue;
				if (nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)
					continue;
				int s=j+1, t=nums.length-1;
				while (s<t) {
					if (nums[i]+nums[j]+nums[s]+nums[t]==target) {
						//add solution
						List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[s], nums[t]);
						if (res.size()==0)
							res.add(ans);
						else if (minor(res.get(res.size()-1), ans))
							res.add(ans);
						if (s<nums.length-1) s++;
						else if (t>j+1) t--;
						else break;
					}
					if (s==nums.length-1 && nums[i]+nums[j]+nums[s]+nums[t]<target)
						break;
					if (t==j+1 && nums[i]+nums[j]+nums[s]+nums[t]>target)
						break;
					if (nums[i]+nums[j]+nums[s]+nums[t]<target) 
						s++;
					if (nums[i]+nums[j]+nums[s]+nums[t]>target)
						t--;
				}
			}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] strs = input.split(" ");
		int[] nums = new int[strs.length];
		for (int i=0; i<strs.length; i++) 
			nums[i] = Integer.parseInt(strs[i]);
		int target = scanner.nextInt();
		System.out.println(fourSum(nums, target));
	}

}
