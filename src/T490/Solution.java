package T490;

import java.util.*;

public class Solution {

    private static final int[][] D = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private Map<Integer, Boolean> cache = new HashMap<>();
    private Set<Integer> preNodes = new HashSet<>();
    private int rows, cols;
    private int[] destination;
    private int[][] maze;

    private int code(int[] point) {
        return point[0] * cols + point[1];
    }

    private boolean hasPath(int[] point) {
        if (cache.containsKey(code(point))) return cache.get(code(point));
        if (point[0] == destination[0] && point[1] == destination[1])
            return true;

        preNodes.add(code(point));
        for (int i = 0; i < 4; i ++) {
            int[] cur = new int[] { point[0], point[1]};
            int steps = -1;
            while (cur[0] >= 0 && cur[0] < rows && cur[1] >= 0 && cur[1] < cols && maze[cur[0]][cur[1]] == 0) {
                cur[0] += D[i][0];
                cur[1] += D[i][1];
                steps ++;
            }
            cur[0] -= D[i][0]; cur[1] -= D[i][1];
            if (steps > 0 && !preNodes.contains(code(cur)) && hasPath(cur)) {
                cache.put(code(cur), true);
                preNodes.remove(code(cur));
                return true;
            }
        }

        preNodes.remove(code(point));
        cache.put(code(point), false);
        return false;
    }


    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.rows = maze.length; this.cols = maze[0].length;
        this.destination = destination;
        this.maze = maze;
        return hasPath(start);
    }

    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = {0, 4};
        int[] destination = {4, 4};
        System.out.println(new Solution().hasPath(maze, start, destination));
    }
}
