package T531;

public class Solution {

	public int findLonelyPixel(char[][] picture) {
		if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;
		int rows = picture.length, cols = picture[0].length;
		int[] inRows = new int[rows];
		int[] inCols = new int[cols];
		for (int i = 0; i < rows; i ++)
			for (int j = 0; j < cols; j ++)
				if (picture[i][j] == 'B') {
					inRows[i] ++; inCols[j] ++;
				}
		int count = 0;
		for (int i = 0; i < rows; i ++)
			for (int j = 0; j < cols; j ++)
				if (picture[i][j] == 'B') {
					if (inRows[i] == 1 && inCols[j] == 1) count ++;
				}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] picture = {
			"WWB".toCharArray(),
			"WBW".toCharArray(),
			"BWW".toCharArray()
		};
		System.out.println(new Solution().findLonelyPixel(picture));
	}

}
