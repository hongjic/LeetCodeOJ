package T541;

public class Solution {

	public String reverseStr(String s, int k) {
		int i = 0, len = s.length();
		StringBuffer sb = new StringBuffer();
		while (i < len) {
			if (i + k > len) sb.append(new StringBuffer(s.substring(i, len)).reverse());
			else {
				sb.append(new StringBuffer(s.substring(i, i + k)).reverse());
				if (i + k * 2 > len)
					sb.append(s.substring(i + k, len));
				else sb.append(s.substring(i + k, i + k * 2));
			}
			i += k * 2;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().reverseStr("abcdefg", 2));
	}

}
