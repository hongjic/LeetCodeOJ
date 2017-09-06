package T537;

public class Solution {

	public String complexNumberMultiply(String a, String b) {
		String[] ar = a.split("\\+");
		String[] br = b.split("\\+");
		int a1 = Integer.valueOf(ar[0]);
		int a2 = Integer.valueOf(ar[1].substring(0, ar[1].length() - 1));
		int b1 = Integer.valueOf(br[0]);
		int b2 = Integer.valueOf(br[1].substring(0, br[1].length() - 1));
		int c1 = a1 * b1 - a2 * b2;
		int c2 = a1 * b2 + a2 * b1;
		return String.format("%d+%di", c1, c2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().complexNumberMultiply("1+0i", "1+0i"));
	}

}
