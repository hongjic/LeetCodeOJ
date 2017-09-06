package T533;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {

	public int findBlackPixel(char[][] picture, int N) {
		if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;
		int rows = picture.length, cols = picture[0].length;
		int[] inRows = new int[rows];
		int[] inCols = new int[cols];
		Map<Integer, Set<Integer>> lines = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < rows; i ++)
			for (int j = 0; j < cols; j ++)
				if (picture[i][j] == 'B') {
					inRows[i] ++; inCols[j] ++;
					if (!lines.containsKey(j))
						lines.put(j, new HashSet<Integer>());
					lines.get(j).add(i);
				}
		
		int res = 0;
		for (int i = 0; i < rows; i ++)
			for (int j = 0; i < cols; j ++) 
				if (picture[i][j] == 'B' && inRows[i] == inRows[j]) {
					String line1 = String.valueOf(picture[i]);
					boolean flag = true;
					for (int k: lines.get(j)) {
						String line2 = String.valueOf(picture[k]);
						if (!line1.equals(line2)) {
							flag = false;
							break;
						}
					}
					if (flag) res ++;
				}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
