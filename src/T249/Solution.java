package T249;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {

	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String st: strings) {
			int d = st.charAt(0) - 'a';
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < st.length(); i ++) {
				int c = st.charAt(i) - d;
				if (c < 97) c += 26;
				sb.append((char)(c));
			}
			String key = sb.toString();
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(st);
		}
		List<List<String>> result = new ArrayList<List<String>>();
		for (String key: map.keySet())
			result.add(map.get(key));
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> result = new Solution().groupStrings(new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
		for (int i = 0; i < result.size(); i ++) {
			for (int j = 0; j < result.get(i).size(); j ++)
				System.out.print(result.get(i).get(j) + ", ");
			System.out.println();
		}
	}

}
