package T323;

public class Solution {

    public int countComponents(int n, int[][] edges) {
        int[] cats = new int[n];
        for (int i = 0; i < n; i ++)
            cats[i] = i;

        int count = n;
        for (int[] edge: edges) {
            int node1 = find(edge[0], cats);
            int node2 = find(edge[1], cats);
            if (node1 != node2) {
                cats[node1] = node2;
                count--;
            }
        }
        return count;
    }

    private int find(int node, int[] cats) {
        while (cats[node] != node)
            node = cats[node];
        return node;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countComponents(5, new int[][] {{0,1},{0,2},{1,2},{3,4}}));
    }
}
