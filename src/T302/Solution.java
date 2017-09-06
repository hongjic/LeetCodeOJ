package T302;

public class Solution {
	
	private char[][] image;
	// O(mlogn + nlogm)
	// if there are only one back pixel region, then in a projected 1D array all black pixels are connected.
	public int minArea(char[][] image, int x, int y) {
		this.image = image;
		int rows = image.length, cols = image[0].length;
		int left = searchColumns(0, y, 0, rows, true);
		int right = searchColumns(y + 1, cols, 0, rows, false);
		int top = searchRows(0, x, left, right, true);
		int bottom = searchRows(x + 1, rows, left, right, false);
		return (right - left) * (bottom - top);
	}
	
	private int searchColumns(int i, int j, int top, int bottom, boolean opt) {
		while (i < j) {
			int k = top, mid = (i + j) / 2;
			while (k < bottom && image[k][mid] == '0') k ++;
			if (k < bottom == opt)
				j = mid;
			else i = mid + 1;
 		}
		return i;
	}
	
	private int searchRows(int i, int j, int left, int right, boolean opt) {
		while (i < j) {
			int k = left, mid = (i + j) / 2;
			while (k < right && image[mid][k] == '0') k ++;
			if (k < right == opt)
				j = mid;
			else i = mid + 1;
		}
		return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] image = new char[][] {
				"0010".toCharArray(), 
				"0110".toCharArray(), 
				"0100".toCharArray()
		};
		System.out.println(new Solution().minArea(image, 0, 2));
	}

}
