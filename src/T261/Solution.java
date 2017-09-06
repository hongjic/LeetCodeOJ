package T261;

import java.util.*;

/*
A valid Tree is a fully connected graph with no circle.
Like topological sorting, but delete all nodes with degree 1.
Time complexity: O(N+E)
 */
public class Solution {

    private void traverseGraph(boolean[] visited, Map<Integer, Set<Integer>> conn, int node) {
        visited[node] = true;
        Set<Integer> nexts = conn.get(node);

        for (int next: nexts) {
            if (!visited[next])
                traverseGraph(visited, conn, next);
        }
    }

    private boolean isFullyConnected(int n, int[][] edges, Map<Integer, Set<Integer>> conn) {
        boolean[] visited = new boolean[n];
        traverseGraph(visited, conn, 0);
        for (int i = 0; i < n; i ++)
            if (!visited[i])
                return false;
        return true;
    }

    private boolean existsCircle(int n, int[][] edges, Map<Integer, Set<Integer>> conn) {
        // nodes with degree 1
        List<Integer> ones = new ArrayList<>();
        // check if there exists nodes with degree 0
        for (int i = 0; i < n; i ++)
            if (conn.get(i).size() <= 1) ones.add(i);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i ++)
            set.add(i);

        while (!ones.isEmpty()) {
            // delete `ones` in set
            for (int node: ones) {
                set.remove(node);
                // delete the edges
                Set<Integer> connects = conn.get(node);
                for (int connect: connects)
                    conn.get(connect).remove(node);
            }
            ones.clear();
            for (int node: set) {
                if (conn.get(node).size() <= 1)
                    ones.add(node);
            }
        }

        return !set.isEmpty();
    }

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> conn = new HashMap<>();
        for (int i = 0; i < n; i ++)
            conn.put(i, new HashSet<>());
        for (int[] edge: edges) {
            conn.get(edge[0]).add(edge[1]);
            conn.get(edge[1]).add(edge[0]);
        }

        return isFullyConnected(n, edges, conn) && !existsCircle(n, edges, conn);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validTree(4, new int[][] {{0,1}, {2,3}}));
        System.out.println(new Solution().validTree(5, new int[][] {{0,1}, {0,2}, {0,3}, {1,4}}));
        System.out.println(new Solution().validTree(5, new int[][] {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}}));
        System.out.println(new Solution().validTree(2, new int[][] {}));
        System.out.println(new Solution().validTree(1, new int[][] {}));
    }
}
