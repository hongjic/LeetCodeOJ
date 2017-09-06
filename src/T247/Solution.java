package T247;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	private static int[] numbers = {0, 1, 6, 8, 9};
	
	public List<String> findStrobogrammatic(int n) {
		List<String> result = new ArrayList<String>();
		generate(result, new StringBuffer(), n, 0);
		return result;
	}
	
	private void generate(List<String> result, StringBuffer sb, int n, int index) {
		if (index == (n + 1) / 2) {
			result.add(buildWhole(sb.toString(), (n & 1) == 1));
			return;
		}
		for (int i = 0; i < 5; i ++) {
			if (index == 0 && i == 0 && n != 1) continue;
			if ((n & 1) == 1 && index == n / 2 && (i == 2 || i == 4)) continue;
			sb.append(numbers[i]);
			generate(result, sb, n, index + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	private String buildWhole(String num, boolean odd) {
		int b = num.length() - 2;
		if (!odd) b = num.length() - 1;
		StringBuffer sb = new StringBuffer(num);
		for (int i = b; i >= 0 ; i --) {
			char c = sb.charAt(i);
			if (c == '9') c = '6';
			else if (c == '6') c = '9';
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result = new Solution().findStrobogrammatic(2);
		for (int i = 0; i < result.size(); i ++)
			System.out.println(result.get(i));
	}

}
