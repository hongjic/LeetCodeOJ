package T245;

import java.util.ArrayList;

public class Solution {

	public int shortestWordDistance(String[] words, String word1, String word2) {
		ArrayList<Integer> p1 = new ArrayList<Integer>();
		ArrayList<Integer> p2 = new ArrayList<Integer>();
		for (int i = 0; i < words.length; i ++) {
			if (words[i].equals(word1))
				p1.add(i);
			if (words[i].equals(word2))
				p2.add(i);
		}
		int i = 0, j = 0;
		int min = Integer.MAX_VALUE;
		while (i < p1.size() && j < p2.size()) {
			if (!p1.get(i).equals(p2.get(j)))
				min = Math.min(min, Math.abs(p1.get(i) - p2.get(j)));
			if (p1.get(i) < p2.get(j)) 
				i ++;
			else j++;
		}
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = new String[] {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(new Solution().shortestWordDistance(words, "makes", "makes"));
	}

}
