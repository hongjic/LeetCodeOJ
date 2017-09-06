package T12_56;
public class T35 {

	public static int searchInsert(int[] nums, int target) {
		int l = 0, r = nums.length-1;
		while (l<r) {
			int m = l +((r-l)>>1);
			if (nums[m]==target) return m;
			if (nums[m]<target) l = m+1;
			else r=m;
		}
		if (nums[l]<target) return l+1;
		return l;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,5,6};
		int target = 4;
		System.out.println(searchInsert(nums, target));
	}

}


//public class Solution {
//
//    public int binarySearchInsert(int[] nums, int start, int end, int target) {
//        if(start>end)
//            return -(start+1); 
//        int mid = start+(end-start)/2;
//        if(nums[mid]==target)
//            return mid;
//        else if(nums[mid]<target)
//            return binarySearchInsert(nums, mid+1, end, target);
//        else
//            return binarySearchInsert(nums, start, mid-1, target);
//    }
//
//    public int searchInsert(int[] nums, int target) {
//        int idx = binarySearchInsert(nums, 0, nums.length-1, target);
//        return idx>=0 ? idx : -idx-1;
//    }
//}