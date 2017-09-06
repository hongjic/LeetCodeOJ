package Contest3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T392 {

	private static boolean isSubsequence(String s, String t) {
		Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		int len_s = s.length();
		int len_t = t.length();
		for (int i=0; i<len_t; i++) {
			if (map.containsKey(t.charAt(i))) 
				map.get(t.charAt(i)).add(i);
			else { 
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(t.charAt(i), list);
			}
		}
		int pre = -1;
		for (int i=0; i<len_s; i++) {
			if (!map.containsKey(s.charAt(i)))
				return false;
			List<Integer> p = map.get(s.charAt(i));
			int j = 0;
			while (j<p.size()) {
				if (p.get(j)>pre) {
					pre = p.get(j);
					break;
				}
				j++;
			}
			if (j == p.size()) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isSubsequence("twxtx", "twxxxxxxtxxxxx"));
		
	}

}
