package T481;

public class Solution {

	// Weekly Contest 14: Magical String
	public int magicalString(int n) {
		StringBuilder sb = new StringBuilder("122");
		int magic = 2, count = 1;
		boolean cur = true; // true == 1/false == 2
		while (magic + 1 < n) {
			for (int i = count + 1; i <= magic; i ++) {
				for (int t = 0; t < sb.charAt(i) - 48; t ++)
					sb.append(cur ? '1' : '2');
				cur = !cur;
			}
			count = magic; magic = sb.length() - 1;
		}
		int sum = 0;
		for (int i = 0; i < n; i ++)
			if (sb.charAt(i) == '1') sum ++;
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().magicalString(100000));
	}

}
