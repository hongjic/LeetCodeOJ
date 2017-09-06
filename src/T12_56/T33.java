package T12_56;
public class T33 {

	private static int search(int[] nums, int target) {
		if (nums==null || nums.length==0) return -1;
		int l=0, r = nums.length-1;
		while (l<r) {
			int m = l+(r-l)/2;
			if (target == nums[m]) return m;
			if (nums[m]>=nums[l])
				if (target<=nums[m] && target>=nums[l]) r = m;
				else l=m+1;
			else 
				if (target>=nums[m] && target<=nums[r]) l = m;
				else r=m-1;
		}
		return nums[l]==target ? l : -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,6,7,0,1,2};
		int target = 4;
		System.out.println(search(nums, target));
	}

}



//public class Solution {
//    public int search(int[] nums, int target) {
//    if (nums == null || nums.length == 0) return -1;
//    int l = 0, r = nums.length - 1;
//    while (l < r) {
//        int m = l + (r - l) / 2;
//        if (nums[m] >= nums[l]) {
//            if (target <= nums[m] && target >= nums[l]) r = m;
//            else l = m + 1;
//        } else {
//            if (target > nums[m] && target <= nums[r]) l = m + 1;
//            else r = m;
//        }
//    }
//    return nums[l] == target ? l : -1;
//}
//}