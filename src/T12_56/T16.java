package T12_56;
import java.util.Arrays;
import java.util.Scanner;


public class T16 {

	private static long diff(int curr, int target) {
		return Math.abs((long)curr-target);
	}
	
	private static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int closest = Integer.MAX_VALUE;
		long mindiff = diff(closest, target);
		for (int first = 0; first<n-2; first++) {
			//若往后不可能再更接近target
			if (nums[first]+nums[first+1]+nums[first+2]>target && 
					diff(nums[first]+nums[first+1]+nums[first+2], target)>mindiff)
				break;
			//third>=second>=first
			for (int second = first+1; second<n-1; second++) {
				//二分查找选择第三个
				int s = second+1;
				int t = n-1;
				int suppose = target-nums[first]-nums[second];
				while (s<t) {
					int p = s+(t-s)/2;
					if (nums[p]>suppose) t = p;
					if (nums[p]<suppose) s = p+1;
					if (nums[p]==suppose) return target;
				}
				//check nums[s]
				if (diff(nums[first]+nums[second]+nums[s], target)<mindiff) {
					mindiff = diff(nums[first]+nums[second]+nums[s], target);
					closest = nums[first]+nums[second]+nums[s];
				}
				//check nums[s+1]
				if (s+1<n && diff(nums[first]+nums[second]+nums[s+1], target)<mindiff) {
					mindiff = diff(nums[first]+nums[second]+nums[s+1], target);
					closest = nums[first]+nums[second]+nums[s+1];
				}
				if (s-1>=second+1 && diff(nums[first]+nums[second]+nums[s-1], target)<mindiff) {
					mindiff = diff(nums[first]+nums[second]+nums[s-1], target);
					closest = nums[first]+nums[second]+nums[s-1];
				}
			}
		}
		return closest;
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
		System.out.println(threeSumClosest(nums, target));
	}

}

//This is the better solution
//public class Solution {
//    public int threeSumClosest(int[] nums, int target) {
//        int minDif = Integer.MAX_VALUE;
//        int result=0;
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (i > 0 && nums[i] == nums[i - 1])
//            continue;
//            for (int start = i + 1, end = nums.length - 1; start < end;) {
//                int sum = nums[i] + nums[start] + nums[end];
//                if (Math.abs(sum - target) < minDif) {
//                    minDif=Math.abs(sum - target);
//                    result=sum;
//                }
//                if (sum> target)
//                    end--;
//                else if (sum < target) {
//                    start++;
//                } 
//                else return result;
//            }
//        }
//        return result;
//    }
//}