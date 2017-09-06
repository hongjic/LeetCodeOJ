package T391;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	private static class RComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[1] != o2[1]) return o1[1] - o2[1];
			return o1[0] - o2[0];
		}
		
	}
	
	public boolean isRectangleCover(int[][] rectangles) {
		// sort rectangles by left bottom
		// find the left bottom and right top of the cover area
		// 俄罗斯方块 
		int num = rectangles.length;
		if (num == 0) return true; 
		
		Arrays.sort(rectangles, new RComparator());
		// find the index of the max top and right
		int maxTop = rectangles[0][3], maxRight = rectangles[0][2], maxTop2 = maxTop, maxRight2 = maxRight;
		for (int i = 1; i < num; i ++) {
			if (rectangles[i][3] > maxTop) 
				maxTop = rectangles[i][3];
			if (rectangles[i][2] > maxRight) 
				maxRight = rectangles[i][2];
			if (rectangles[i][3] >= maxTop2 && rectangles[i][2] >= maxRight2) {
				maxTop2 = rectangles[i][3];
				maxRight2 = rectangles[i][2];
			}
		}
		if (maxTop != maxTop2 || maxRight != maxRight2) return false;
		int minBottom = rectangles[0][1], minLeft = rectangles[0][0];
		
		int[] height = new int[maxRight - minLeft];
		Arrays.fill(height, minBottom);
		int level = minBottom, pos = minLeft;
		int i = 0;
		
		while (i < num) {
			if (rectangles[i][1] != level || rectangles[i][0] != pos) return false;
			// update height
			for (int j = pos; j < rectangles[i][2]; j ++) {
				if (height[j - minLeft] != level) return false;
				if (rectangles[i][3] <= height[j - minLeft]) return false;
				height[j - minLeft] = rectangles[i][3];
			}
			level = height[0];
			pos = minLeft;
			for (int j = minLeft; j < maxRight; j ++)
				if (height[j - minLeft] < level) {
					level = height[j - minLeft];
					pos = j;
				}
			i ++;
		}
		if (level == maxTop) return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("t391.input");
		String input = null; 
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			input = reader.readLine();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		input = input.substring(1, input.length() - 2);
		String[] rects = input.split("]");
		rects[0] = rects[0].substring(1);
		for (int i = 1; i < rects.length; i ++)
			rects[i] = rects[i].substring(2);
		int[][] rect = new int[rects.length][4];
		for (int i = 0; i < rects.length; i ++) {
			String[] nums = rects[i].split(",");
			for (int j = 0; j < 4; j ++)
				rect[i][j] = Integer.valueOf(nums[j]);
		}
		
//		int[][] rect = new int[][] {{1,1,3,3}, {3,1,4,2}, {3,2,4,4}, {1,3,2,4}, {2,3,3,4}};
		System.out.println(new Solution().isRectangleCover(rect));
	}

}
