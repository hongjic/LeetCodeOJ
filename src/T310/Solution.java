package T310;

import java.util.*;

public class Solution {

    /*
    For a tree we can do some thing similar. We start from every end, by end we mean vertex of degree 1 (aka leaves).
    We let the pointers move the same speed. When two pointers meet, we keep only one of them, until the last two
    pointers meet or one step away we then find the roots.
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        List<Set<Integer>> conn = new ArrayList<>();
        for (int i = 0; i < n; i ++) conn.add(new HashSet<>());
        for (int[] edge: edges) {
            conn.get(edge[0]).add(edge[1]);
            conn.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i ++)
            if (conn.get(i).size() == 1)
                leaves.add(i);

        int nn = n - leaves.size();
        while (nn > 0) {
            List<Integer> nextLeaves = new ArrayList<>();
            for (int leaf: leaves) {
                int next = conn.get(leaf).iterator().next();
                conn.get(next).remove(leaf);
                if (conn.get(next).size() == 1) {
                    nextLeaves.add(next);
                    nn --;
                }
            }
            leaves = nextLeaves;
        }
        return new ArrayList<>(leaves);
    }

    public static void main(String[] args) {
        List<Integer> res = new Solution().findMinHeightTrees(1, new int[][] {});
        for (int r: res)
            System.out.print(r + ", ");
    }
}
