package T187;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Solution2 {
	
	private static final char[] map = new char[26];
	
	static {
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;
	}

	public List<String> findRepeatedDnaSequences(String s) {
		Set<Integer> words = new HashSet<Integer>();
		Set<String> result = new HashSet<String>();
		
		for (int i = 0; i <= s.length() - 10; i ++) {
			int v = 0;
			for (int j = i; j < i + 10; j ++) {
				v <<= 2;
				v |= map[s.charAt(j) - 'A'];
			}
			if (!words.add(v)) 
				result.add(s.substring(i, i + 10));
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
