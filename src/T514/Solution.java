package T514;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
	public int findRotateSteps(String ring, String key) {
		// all possible positions for each appearing character.
		Map<Character, List<Integer>> p = new HashMap<Character, List<Integer>>();
		for (int i = 0; i < ring.length(); i ++) {
			char c = ring.charAt(i);
			if (!p.containsKey(c)) 
				p.put(c, new ArrayList<Integer>());
			p.get(c).add(i);
		}
		int lenR = ring.length(), lenK = key.length();
		// steps[i][j] = min steps needed to match key[i] on ring[j]
		int[][] steps = new int[lenK][lenR];
		for (int[] arr: steps)
			Arrays.fill(arr, Integer.MAX_VALUE);
		for (int i = 0; i < lenK; i ++) {
			List<Integer> pList = p.get(key.charAt(i));
			for (int index = 0; index < pList.size(); index ++) {
				int j = pList.get(index);
				if (i == 0) 
					steps[i][j] = Math.min(steps[i][j], Math.min(j, lenR - j));
				else {
					List<Integer> lastPos = p.get(key.charAt(i - 1));
					for (int lastP: lastPos) {
						int d = Math.abs(lastP - j);
						steps[i][j] = Math.min(steps[i][j], steps[i - 1][lastP] + Math.min(d, lenR - d));
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int position: p.get(key.charAt(key.length() - 1))) {
			min = Math.min(min, steps[lenK - 1][position]);
		}
		return min + lenK;
	}
	
	public static void main(String[] args) {
		String ring = "acedebf";
		String key = "aeb";
		System.out.println(new Solution().findRotateSteps(ring, key));
	}
}
