package T288;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class ValidWordAbbr {

	private Map<String, Integer> abbs;
	private Set<String> origins;
	
	public ValidWordAbbr(String[] dictionary) {
		abbs = new HashMap<String, Integer>();
		origins = new HashSet<String>();
		for (int i = 0; i < dictionary.length; i ++) 
			if (origins.add(dictionary[i])) {
				String abbr = transfer(dictionary[i]);
				abbs.put(abbr, abbs.getOrDefault(abbr, 0) + 1);
			}
	}
	
	public boolean isUnique(String word) {
		String  abb = transfer(word);
		return !abbs.containsKey(abb) || (origins.contains(word) && abbs.get(abb) == 1);
	}
	
	private String transfer(String origin) {
		if (origin.length() > 2) 
			return origin.charAt(0) + String.valueOf(origin.length() - 2) + origin.charAt(origin.length() - 1);
		else
			return origin;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dict = new String[] {"deer", "door", "cake", "card", "card"};
		ValidWordAbbr vwa = new ValidWordAbbr(dict);
		System.out.println(vwa.isUnique("dear"));
		System.out.println(vwa.isUnique("cart"));
		System.out.println(vwa.isUnique("cane"));
		System.out.println(vwa.isUnique("make"));
		System.out.println(vwa.isUnique("card"));
		
	}

}
