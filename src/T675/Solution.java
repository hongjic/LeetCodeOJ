package T675;

import java.util.*;

public class Solution {
    private static final int[][] D = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    private boolean valid(int x, int y, int rows, int cols, List<List<Integer>> forest) {
        return x >= 0 && x < rows && y >= 0 && y < cols && forest.get(x).get(y) > 0;
    }

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0 || forest.get(0).size() == 0)
            return 0;
        int rows = forest.size();
        int cols = forest.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return forest.get(o1[0]).get(o1[1]) - forest.get(o2[0]).get(o2[1]);
            }
        });
        for (int i = 0; i < rows; i ++)
            for (int j = 0; j < cols; j ++)
                if (forest.get(i).get(j) > 1) pq.offer(new int[] {i, j});

        int px = 0, py = 0, sum = 0;
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int length = calculatePath(px, py, next[0], next[1], forest, rows, cols);
            if (length == -1) return -1;
            sum += length;
            px = next[0]; py = next[1];
        }

        return sum;
    }

    private int calculatePath(int px, int py, int targetx, int targety, List<List<Integer>> forest, int rows, int cols) {
        if (px == targetx && py == targety) return 0;
        int[][] path = new int[rows][cols];
        for (int i = 0; i < rows; i ++)
            Arrays.fill(path[i], -1);
        path[px][py] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {px, py});
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int base = path[point[0]][point[1]];
            for (int i = 0; i < 4; i ++) {
                int nx = point[0] + D[i][0], ny = point[1] + D[i][1];
                if (valid(nx, ny, rows, cols, forest) && path[nx][ny] == -1) {
                    path[nx][ny] = base + 1;
                    if (nx == targetx && ny == targety) return path[nx][ny];
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //List<List<Integer>> forest = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(0,0,4), Arrays.asList(7,6,5));
        List<List<Integer>> forest = Arrays.asList(Arrays.asList(54581641,64080174,24346381,69107959), Arrays.asList(86374198,61363882,68783324,79706116),
                Arrays.asList(668150,92178815,89819108,94701471), Arrays.asList(83920491,22724204,46281641,47531096), Arrays.asList(89078499,18904913,25462145,60813308));
        //List<List<Integer>> forest = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(0,0,0), Arrays.asList(7,6,5));
        System.out.println(new Solution().cutOffTree(forest));
    }
}
