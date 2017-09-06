package T336;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class Solution {

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (words == null || words.length < 2) return res;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i ++)
			map.put(words[i], i);
		
		for (int i = 0; i < words.length; i ++) {
			for (int j = 0; j <= words[i].length(); j ++) {
				String st1 = words[i].substring(0, j);
				String st2 = words[i].substring(j);
				if (isPalindrome(st1)) {
					String st2re = new StringBuilder(st2).reverse().toString();
					if (map.containsKey(st2re) && map.get(st2re) != i) {
						res.add(Arrays.asList(map.get(st2re), i));
					}
				}
				if (isPalindrome(st2) && st2.length() != 0) {
					String st1re = new StringBuilder(st1).reverse().toString();
					if (map.containsKey(st1re) && map.get(st1re) != i) {
						res.add(Arrays.asList(i, map.get(st1re)));
					}
				}
			}
		}
		return res;
	}
	
	private boolean isPalindrome(String st) {
		int left = 0;
		int right = st.length() - 1;
		while (left <= right) {
			if (st.charAt(left ++) != st.charAt(right --)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new Solution().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
		for (int i = 0; i < res.size(); i ++) 
			System.out.println(res.get(i).get(0) + ", " + res.get(i).get(1));
	}

}
