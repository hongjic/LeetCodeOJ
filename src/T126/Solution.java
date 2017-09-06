package T126;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Solution {
	
	private void addPaths(List<List<String>> result, String str, String beginWord, LinkedList<String> cur, Map<String, List<String>> route) {
		if (str.equals(beginWord)) {
			LinkedList<String> re = new LinkedList<String>();
			re.addAll(cur);
			re.addFirst(str);
			result.add(re);
			return;
		}
		if (!route.containsKey(str)) return;
		List<String> prefixes = route.get(str);
		cur.addFirst(str);
		for (String prefix: prefixes) {
			addPaths(result, prefix, beginWord, cur, route);
		}
		cur.removeFirst();
	}
	// want to find a pdf,actually just a paragraph.  but i don't remember the title of it, and  
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<String>(wordList);
		List<List<String>> result = new ArrayList<List<String>>();
		if (!wordSet.contains(endWord)) return result;
		Set<String> visited = new HashSet<String>(), boundary = new HashSet<String>(), set;
		visited.add(beginWord); boundary.add(beginWord);
		Map<String, List<String>> route = new HashMap<String, List<String>>();
		route.put(beginWord, null);
		boolean found = false;
		
		while (boundary.size() > 0) {
			set = new HashSet<String>();
			for (String preStr: boundary) {
				char[] cl = preStr.toCharArray();
				for (int index = 0; index < cl.length; index ++) 
					for (char c = 'a'; c <= 'z'; c ++)
						if (c != cl[index]) {
							char tmp = cl[index];
							cl[index] = c;
							String newStr = String.valueOf(cl);
							if (newStr.equals(endWord)) {
								if (!route.containsKey(newStr)) route.put(newStr, new ArrayList<String>());
								route.get(newStr).add(preStr);
								found = true;
							}
							else if (!visited.contains(newStr) && wordSet.contains(newStr)) {
								set.add(newStr);
								if (!route.containsKey(newStr)) route.put(newStr, new ArrayList<String>());
								route.get(newStr).add(preStr);
							}
							cl[index] = tmp;
						}
			}
			visited.addAll(set);
			boundary = set;
			if (found) break;
		}
		addPaths(result, endWord, beginWord, new LinkedList<String>(), route);
		return result;
	}
	
	public static void main(String[] args) {
		String beginWord = "hot", endWord = "dog";
		List<String> wordList = Arrays.asList("hot", "dog", "red", "tax", "tad", "den", "rex", "pee");
		List<List<String>> path = new Solution().findLadders(beginWord, endWord, wordList);
		for (int i = 0; i < path.size(); i ++) {
			for (int j = 0; j < path.get(i).size(); j ++)
				System.out.print(path.get(i).get(j) + " ");
			System.out.println();
		}
	}
}
