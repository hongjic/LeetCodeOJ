package T275;

public class Solution {

	// the difference is that we can use binary search to count bigger elements
	// the time complexity is now O(log^2(n))
	public int hIndex(int[] citations) {
		int len = citations.length;
		int left = 0, right = len + 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (mid > countBigger(citations, mid)) right = mid;
			else left = mid + 1;
		}
		return left - 1;
	}
	
	private int countBigger(int[] citations, int target) {
		// find the index of the first element bigger or equal to target
		int len = citations.length;
		if (len == 0) return 0;
		int left = 0, right = len - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (citations[mid] < target) left = mid + 1;
			else right = mid;
		}
		if (citations[left] >= target) return len - left;
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = new int[] {};
		System.out.println(new Solution().hIndex(citations));
	}

}
