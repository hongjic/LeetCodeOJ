package T187;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


/*
 * Solution2 uses the same algorithm, but a faster implementation
 */
public class Solution {

	public List<String> findRepeatedDnaSequences(String s) {
		if (s == null || s.length() <= 10) 
			return new ArrayList<String>();
		Set<String> result = new HashSet<String>();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i <= s.length() - 10; i ++) {
			String cur = s.substring(i, i + 10);
			if (!set.add(cur))
				result.add(cur);
		}
		return new ArrayList<String>(result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result = new Solution().findRepeatedDnaSequences("AAAAAAAAAAA");
		for (int i = 0; i < result.size(); i ++)
			System.out.println(result.get(i));
	}

}
