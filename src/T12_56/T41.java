package T12_56;
public class T41 {

	public static int firstMissingPositive(int[] nums) {
		int len = nums.length;
		if (len == 0) return 1;
		int i=0;
		while (i<len) {
			if (nums[i] == i+1 || nums[i]<=0 || nums[i]>=len+1) i++;
			else if (nums[nums[i]-1]!=nums[i]) swap(nums, nums[i]-1, i);
			else i++;
		}
		i = 0;
		while (i<len && nums[i]==i+1) i++;
		return i+1;
	}
	
	private static void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,-1,1};
		System.out.println(firstMissingPositive(nums));
	}

}














//public class Solution {
//    public int firstMissingPositive(int[] nums) {
//
//    if(nums == null || nums.length == 0) 
//        return 1;
//
//    int numsArrayLen = nums.length;
//    int[] result = new int[numsArrayLen+2];
//
//    for (int num : nums){
//        if ((num<1) || (num>numsArrayLen) ) {
//            continue;
//        }
//        result[num]++;
//    }
//
//    for (int i=1; i<result.length; i++){
//        if (result[i] == 0){
//            return i;
//        }
//    }
//    return 1;
//}
//}