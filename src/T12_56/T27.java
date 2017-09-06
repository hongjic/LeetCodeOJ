package T12_56;
public class T27 {

	private static int removeElement(int[] nums, int val) {
		int len = nums.length;
		if (len==0) return 0;
		if (len==1)
			if (nums[0]==val) return 0;
			else return 1;
		int p1 = -1, p2 = 0;
		while (p2<len) {
			if (val!=nums[p2]) {
				p1++;
				nums[p1] = nums[p2];
			}
			p2++;
		}
		return p1+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//public class Solution {
//    public int removeElement(int[] nums, int val) {
//    int start = 0, end = nums.length-1;
//    while(start<=end){
//        if(nums[start] == val){
//            if(nums[end] == val)
//                end--;    
//            else{
//                nums[start] = nums[end];
//                start++; end --;
//            }
//        }else{
//            start++;
//        }
//    }
//    return start;
//}
//}