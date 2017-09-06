package T274;

public class Solution {

	public int hIndex(int[] citations) {
		int len = citations.length;
		int left = 0, right = len + 1;
		while (left < right) {
			int mid = (left + right) / 2;
			int sum = 0;
			for (int i = 0; i < len; i ++)
				if (citations[i] >= mid) sum ++;
			if (sum < mid) right = mid;
			else left = mid + 1;
		}
		return left - 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = new int[]{0 , 0};
		System.out.println(new Solution().hIndex(citations));
	}

}
