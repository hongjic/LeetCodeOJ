package T320;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<String> generateAbbreviations(String word) {
		List<String> results = new ArrayList<String>();
		generate(results, word.toCharArray(), 0, 0, new StringBuffer());
		return results;
	}
	
	private void generate(List<String> results, char[] word, int index, int stack, StringBuffer result) {
		if (index == word.length) {
			// we have generated the word
			int len = result.length();
			if (stack > 0) result.append(stack);
			results.add(result.toString());
			result.delete(len, result.length());
			return;
		}
		// no abbreviation
		int len = result.length();
		if (stack > 0) result.append(stack);
		result.append(word[index]);
		generate(results, word, index + 1, 0, result);
		result.delete(len, result.length());
		
		// abbreviation
		generate(results, word, index + 1, stack + 1, result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> results = new Solution().generateAbbreviations("");
		for (int i = 0; i < results.size(); i ++)
			System.out.println(results.get(i));
	}

}
