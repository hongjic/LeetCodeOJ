package T492;

public class Solution {

	public int[] constructRectangle(int area) {
		int sqrt = (int)Math.ceil(Math.sqrt((double) area));
		while (sqrt <= area && area % sqrt != 0) sqrt ++;
		return new int[] {sqrt, area / sqrt};
	}
	
	public static void main(String[] args) {
		int[] res = new Solution().constructRectangle(10000000);
		System.out.println(res[0] + ", " + res[1]);
	}
}
