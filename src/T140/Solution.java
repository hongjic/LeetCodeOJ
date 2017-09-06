package T140;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Solution {

	// didn't pass. TLE.  guess may because garbage collection?
	public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<String>(wordDict);
		int len = s.length();
		List<List<String>> res = new ArrayList<List<String>>();
		res.add(Arrays.asList(""));
		for (int i = 1; i <= len; i ++) {
			res.add(new ArrayList<String>());
			for (int j = 1; j <= i; j ++)
				if (set.contains(s.substring(j - 1, i)) && res.get(j - 1).size() > 0) {
					for (int k = 0; k < res.get(j - 1).size(); k ++)
						res.get(i).add(res.get(j - 1).get(k) + (j - 1 == 0 ? "" : " ") + s.substring(j - 1, i));
				}
		}
		return res.get(len);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i));
	}

}
