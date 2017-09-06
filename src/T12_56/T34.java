package T12_56;
public class T34 {
	//flag = true means search the left point, flag = false means the right point
	private static int searchPosition(int[] nums, int target, boolean flag) {
		int l = 0, r = nums.length-1, m, index=-1;
		while (l<=r) {
			m = l + ((r-l)>>1);
			if (flag) {
				if (target<=nums[m]) r = m-1;
				else l = m+1;
			}
			else {
				if (target>=nums[m]) l = m+1;
				else r = m-1;
			}
			if (nums[m]==target) index = m;
		}
		return index;
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		if (nums.length==0) {
			res[0] = res[1] = -1;
			return res;
		}
		res[0] = searchPosition(nums, target, true);
		if (res[0]==-1) {
			res[1] = -1;
			return res;
		}
		res[1] = searchPosition(nums, target, false);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,7,7,7,8,8,8,8,9,9,10};
		int target = 8;
		int[] res = searchRange(nums, target); 
		System.out.println(res[0]+" "+res[1]);
	}

}



//public class Solution {
//    public int[] searchRange(int[] A, int target) {
//    int start = findPosition(A, target, false);
//    int end = findPosition(A, target, true);
//    return new int[]{start, end};
//}
//
//private int findPosition(int[] A, int target, boolean isLast) {
//    int low = 0, high = A.length-1, index = -1;
//    while (low <= high) {
//        int mid = low + ((high - low) >> 1);
//        if(isLast){
//            if (A[mid] <= target) low = mid + 1;
//            else high = mid-1;
//        } else{
//            if (A[mid] < target) low = mid + 1;
//            else high = mid-1;
//        }
//        if(A[mid] == target) index = mid; /** update index */
//    }
//    return index;
//}
//}