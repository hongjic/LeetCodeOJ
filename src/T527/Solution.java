package T527;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {

	public List<String> wordsAbbreviation(List<String> dict) {
		String[] res = new String[dict.size()];
	
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		String abbr = null;
		for (int i = 0; i < dict.size(); i ++) {
			String st = dict.get(i);
			if (st.length() <= 3) abbr = st;
			else 
				abbr = st.charAt(0) + String.valueOf(st.length() - 2) + st.charAt(st.length() - 1);
			if (!map.containsKey(abbr))
				map.put(abbr, new ArrayList<Integer>());
			map.get(abbr).add(i);
		}
		reduce(map, res);
		int prefix = 1;
		
		while (!map.isEmpty()) {
			Map<String, List<Integer>> nmap = new HashMap<String, List<Integer>>();
			longerAbbr(nmap, map, ++ prefix, dict);
			map = nmap;
			reduce(map, res);
		}
		
		List<String> result = new ArrayList<String>();
		for (String st: res) result.add(st);
		return result;
	}
	
	private void longerAbbr(Map<String, List<Integer>> nmap, Map<String, List<Integer>> map, int prefix, List<String> dict) {
		int len = 0, rp = 0, mid;
		String ab = null;
		
		for (String abbr: map.keySet()) {
			List<Integer> indexes = map.get(abbr);
			len = dict.get(indexes.get(0)).length();
			
			rp = prefix;
			if (prefix + 2 == len) rp = prefix + 1;
			
			for (int index: indexes) {
				mid = len - rp - 1;
				ab = dict.get(index).substring(0, rp) + (mid > 0 ? String.valueOf(mid) : "") + dict.get(index).charAt(len - 1);
				if (!nmap.containsKey(ab))
					nmap.put(ab, new ArrayList<Integer>());
				nmap.get(ab).add(index);
			}
		}
	}
	
	
	private void reduce(Map<String, List<Integer>> map, String[] res) {
		ArrayList<String> singleAbbrs = new ArrayList<String>();
		for (String abbr: map.keySet()) {
			List<Integer> indexes = map.get(abbr);
			if (indexes.size() == 1) {
				res[indexes.get(0)] = abbr;
				singleAbbrs.add(abbr);
			}
		}
		for (String singleAbbr: singleAbbrs)
			map.remove(singleAbbr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> dict = Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion");
		List<String> res = new Solution().wordsAbbreviation(dict);
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i));
	}

}
