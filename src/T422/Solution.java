package T422;

import java.util.List;
import java.util.Arrays;

public class Solution {

	public boolean validWordSquare(List<String> words) {
		int m = words.size();
		if (m == 0) return true;
		for (int i = 0; i < m ; i ++) {
			String st = words.get(i);
			//[st.length() - 1][i] must exist and nothing below it.
			if (words.size() < st.length()) return false;
			if (words.size() == st.length() && words.get(st.length() - 1).length() <= i) return false;
			if (words.size() > st.length() && (words.get(st.length() - 1).length() <= i || words.get(st.length()).length() > i)) return false;
			for (int j = 0; j < st.length(); j ++)
				if (st.charAt(j) != words.get(j).charAt(i)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().validWordSquare(Arrays.asList("ball", "area", "read", "lady")));
	}

}
