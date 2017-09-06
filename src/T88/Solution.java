package T88;

public class Solution {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1,
			p2 = n - 1,
			p = m + n - 1;
		while (p >= 0) {
			if (p2 < 0 || (p1 >= 0 && nums1[p1] >= nums2[p2])) {
				nums1[p] = nums1[p1];
				p1 --;
			}
			else if (p1 < 0 || (p2 >= 0 && nums1[p1] < nums2[p2])) {
				nums1[p] = nums2[p2];
				p2 --;
			}
			p --;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums1 = new int[]{0};
		int[] nums2 = new int[]{1};
		sol.merge(nums1, 0, nums2, 1);
		for (int i = 0; i < 1; i ++)
			System.out.print(nums1[i] + " ");
	}

}
