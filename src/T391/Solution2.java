package T391;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class Solution2 {

	// math
	// 1) the large rectangle area should be equal to the sum of small rectangles
	// 2) count of all the points should be even, and that of all the four corner points should be one
	
	public boolean isRectangleCover(int[][] rectangles) {
		
		if (rectangles.length == 0 || rectangles[0].length == 0) return false;

        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        
        HashSet<String> set = new HashSet<String>();
        int area = 0;
        
        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            String s1 = rect[0] + " " + rect[1];
            String s2 = rect[0] + " " + rect[3];
            String s3 = rect[2] + " " + rect[3];
            String s4 = rect[2] + " " + rect[1];
            
            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }
        
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) return false;
        
        return area == (x2-x1) * (y2-y1);
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
		
		System.out.println(new Solution2().isRectangleCover(rect));
	}

}
