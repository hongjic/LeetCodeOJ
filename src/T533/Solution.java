package T533;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findBlackPixel(char[][] picture, int N) {
        int rows = picture.length;
        if (rows == 0) return 0;
        int cols = picture[0].length;
        if (cols == 0) return 0;

        Map<String, Integer> map = new HashMap<>();
        int[] colCount = new int[cols];

        // scan rows
        for (int i = 0; i < rows; i ++) {
            String key = scanRow(picture, i, cols, N, colCount);
            if (key != null) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int result = 0;
        for (String key: map.keySet())
            if (map.get(key) == N) {
                for (int j = 0; j < cols; j ++)
                    if (key.charAt(j) == 'B' && colCount[j] == N)
                        result += N;
            }

        return result;
    }

    private String scanRow(char[][] picture, int rowIndex, int cols, int target, int[] colCount) {
        int blackCount = 0;
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < cols; j ++) {
            if (picture[rowIndex][j] == 'B') {
                blackCount ++;
                colCount[j] ++;
            }
            sb.append(picture[rowIndex][j]);
        }

        if (blackCount == target) return sb.toString();
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findBlackPixel(new char[][] {"WBWBBW".toCharArray(), "WBWBBW".toCharArray(), "WBWBBW".toCharArray(), "WWBWBW".toCharArray()}, 3));
    }
}
