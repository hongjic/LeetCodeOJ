package T244;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class WordDistance {
	
	private Map<String, ArrayList<Integer>> positions;

	public WordDistance(String[] words) {
		positions = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < words.length; i ++) {
			if (!positions.containsKey(words[i]))
				positions.put(words[i], new ArrayList<Integer>());
			positions.get(words[i]).add(i);
		}
	}
	
	public int shortest(String word1, String word2) {
		ArrayList<Integer> p1 = positions.get(word1);
		ArrayList<Integer> p2 = positions.get(word2);
		int i = 0, j = 0;
		int min = Integer.MAX_VALUE;
		while (i < p1.size() && j < p2.size()) {
			min = Math.min(min, Math.abs(p1.get(i) - p2.get(j)));
			if (p1.get(i) < p2.get(j)) 
				i ++;
			else j++;
		}
		return min;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Your WordDistance object will be instantiated and called as such:
		String[] words = new String[] {"practice", "makes", "perfect", "coding", "makes"};
		WordDistance wordDistance = new WordDistance(words);
		System.out.println(wordDistance.shortest("practice", "makes"));
		System.out.println(wordDistance.shortest("makes", "coding"));
	}
	

}
