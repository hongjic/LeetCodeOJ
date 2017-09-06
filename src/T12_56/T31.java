package T12_56;
import java.util.Arrays;

public class T31 {

	private static void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
	private static void nextPermutation(int[] nums) {
		int len_n = nums.length;
		if (len_n==1) return;
		int i = len_n-1;
		while (i-1>=0 && nums[i-1]>=nums[i]) {
			i--;
		}
		if (i==0) {
			Arrays.sort(nums);
			return;
		}
		int p = nums[i-1],
			min = nums[i],
			min_index = i;
		for (int j=i; j<len_n; j++)
			if (nums[j]>p && nums[j]<min) {
				min = nums[j];
				min_index = j;
			}
		swap(nums, min_index, i-1);
		Arrays.sort(nums, i, len_n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1};
		nextPermutation(nums);
		for (int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
	}

}





//public class Solution {
//    public void nextPermutation(int[] nums) {
//    int pivot = indexOfLastPeak(nums) - 1;
//    if(pivot != -1){
//        int pivotSuccessor = lastIndexOfGreater(nums, nums[pivot]);
//        int temp = nums[pivot];
//        nums[pivot] = nums[pivotSuccessor];
//        nums[pivotSuccessor] = temp;
//    }
//    int start = pivot + 1, end = nums.length - 1;
//    while(start < end){
//        int temp = nums[start];
//        nums[start++] = nums[end];
//        nums[end--] = temp;
//    }
//}
//
//
//private int indexOfLastPeak(int [] nums){
//    for(int i = nums.length - 1 ; i > 0; i--){
//        if(nums[i] > nums[i - 1]) return i;
//    }
//    return 0; /** first index */
//}
//
//private int lastIndexOfGreater(int [] nums, int threshold){
//    for(int i = nums.length - 1 ; i >= 0; i--){
//        if(nums[i] > threshold) return i;
//    }
//    return -1; /** shouldn't be executed */
//}
//}