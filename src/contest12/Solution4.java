package contest12;

public class Solution4 {

	public String encode(String s) {
		if (s == null || s.length() == 0)
			return s;
		boolean end = false;
		
		while (!end) {
			end = true;
			int len = s.length();
			StringBuffer sb = new StringBuffer();
			sb.append(s.charAt(0));
			
			int jMin = 0, i = 1;
			while (i < len) {
				boolean flag = false;
				for (int j = jMin; j < i; j ++) {
					int matchLen = i - j;
					int num = 1;
					while (j + matchLen * (num + 1) <= len && match(s, j + matchLen * num, j, matchLen))
						num ++;
					if (matchLen * num > matchLen + 2 + String.valueOf(num).length()) {
						//可以压缩
						String pattern = s.substring(j, i);
						sb.delete(sb.length() - matchLen, sb.length());
						sb.append(num).append('[').append(pattern).append(']');
						jMin = j + matchLen * num;
						flag = true;
						break;
					}
				}
				if (flag) {
					i = jMin;
					end = false;
				}
				if (i >= len) break;
				sb.append(s.charAt(i));
				i ++;
			}
			s = sb.toString();
		}
		return s;
	}
	
	private boolean match(String s, int ia, int ib, int len) {
		for (int i = 0; i < len; i ++)
			if (s.charAt(ia + i) != s.charAt(ib + i))
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		System.out.println(sol.encode("abababaabababababcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefg"));
	}

}
