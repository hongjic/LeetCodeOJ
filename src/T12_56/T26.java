package T12_56;
public class T26 {

	private static int removeDuplicates(int[] nums) {
		int len = nums.length;
		if (len==0) return 0;
		int p1 = 0, p2 = 1;
		while (p2<len) {
			if (nums[p1]!=nums[p2]) {
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