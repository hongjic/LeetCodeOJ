package T505;

import java.util.*;

/*
Dijkstra.
 */
public class Solution {

    private static final int[][] D = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length, cols = maze[0].length;
        Set<int[]> candidates = new HashSet<>();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i ++)
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        matrix[start[0]][start[1]] = 0;
        candidates.add(new int[] {start[0], start[1]});

        while (!candidates.isEmpty()) {

            int minPath = Integer.MAX_VALUE;
            int[] closest = null;
            for (int[] point: candidates) {
                if (matrix[point[0]][point[1]] < minPath) {
                    minPath = matrix[point[0]][point[1]];
                    closest = point;
                }
            }
            assert closest != null;
            candidates.remove(closest);
            if (closest[0] == destination[0] && closest[1] == destination[1])
                return minPath;

            for (int i = 0; i < 4; i ++) {
                int[] point = new int[] {closest[0], closest[1]};
                int steps = -1;
                while (point[0] >= 0 && point[0] < rows && point[1] >= 0 && point[1] < cols && maze[point[0]][point[1]] == 0) {
                    point[0] += D[i][0];
                    point[1] += D[i][1];
                    steps ++;
                }
                point[0] -= D[i][0]; point[1] -= D[i][1];
                if (steps > 0 && steps + matrix[closest[0]][closest[1]] < matrix[point[0]][point[1]]) {  // update shortestPath
                    matrix[point[0]][point[1]] = steps + matrix[closest[0]][closest[1]];
                    candidates.add(point);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
//        int[] start = {0, 4};
//        int[] destination = {4, 4};
        int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = {0, 4};
        int[] destination = {3, 2};
        System.out.println(new Solution().shortestDistance(maze, start, destination));
    }
}
