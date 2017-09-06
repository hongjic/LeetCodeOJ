package T101_end;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class T205 {

	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null) return false;
		int lens = s.length(), lent = t.length();
		if (lens != lent) return false;
		Map<Character, Character> map = new HashMap<Character, Character>();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < lens; i ++) {
			boolean cont = map.containsKey(s.charAt(i));
			if (!cont) {
				map.put(s.charAt(i), t.charAt(i));
			}
			else {
				if (map.get(s.charAt(i)) != t.charAt(i))
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T205 t205 = new T205();
		System.out.println(t205.isIsomorphic("papper", "tittle"));
	}

}
