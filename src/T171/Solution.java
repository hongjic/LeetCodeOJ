package T171;

public class Solution {

	public int titleToNumber(String s) {
		int len = s.length(), sum = 0, multi = 1;
		for (int i = len - 1; i >= 0; i --) {
			sum += (s.charAt(i) - 'A') * multi;
			multi *= 26;
		}
		multi = 26;
		for (int i = 1; i <= len - 1; i ++) {
			sum += multi;
			multi *= 26;
		}
		return sum + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().titleToNumber("DCBAA"));
	}

}
