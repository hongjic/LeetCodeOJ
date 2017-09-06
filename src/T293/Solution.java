package T293;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<String> generatePossibleNextMoves(String s) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < s.length() - 1; i ++)
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+')
				res.add(new StringBuilder(s).replace(i, i + 2, "--").toString());
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = new Solution().generatePossibleNextMoves("++++");
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i));
	}

}
