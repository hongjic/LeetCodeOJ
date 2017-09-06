package T101_end;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T139 {

	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0)
			return false;
		int len = s.length();
		List<Integer> trueIndex = new ArrayList<Integer>();
		trueIndex.add(0);
		for (int i = 0; i < len; ++ i) {
			for (int index: trueIndex) {
				String add = s.substring(index, i + 1);
				if (wordDict.contains(add)) {
					trueIndex.add(i + 1);
					break;
				}
			}
		}
		if (trueIndex.get(trueIndex.size() - 1) == len)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T139 t139 = new T139();
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(t139.wordBreak("leetcode", wordDict));
	}

}
