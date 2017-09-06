package T140;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution2 {

	private Map<String, List<String>> map;
	private Set<String> dict;
	
	public List<String> wordBreak(String s, List<String> dict) {
		this.dict = new HashSet<String>(dict);
		this.map = new HashMap<String, List<String>>();
		return recursion(s);
	}
	
	private List<String> recursion(String s) {
		if (map.containsKey(s)) return map.get(s);
		List<String> result = new ArrayList<String>();
		if (dict.contains(s)) result.add(s);
		for (int i = 1; i < s.length(); i ++) {
			String word = s.substring(i);
			if (dict.contains(word)) {
				String remain = s.substring(0, i);
				result.addAll(combine(word, recursion(remain)));
			}
		}
		map.put(s, result);
		return result;
	}
	
	private List<String> combine(String word, List<String> pre) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < pre.size(); i ++)
			res.add(pre.get(i) + " " + word);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = new Solution2().wordBreak("aaaaaaa", Arrays.asList("a", "aa", "aaaa"));
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i));
	}

}
