package T549;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

/*
find longest downward increasing & decreasing path
 */
public class Solution {

    private Map<TreeNode, Integer> maxIncrease = new HashMap<>();
    private Map<TreeNode, Integer> maxDecrease = new HashMap<>();

    private int longestIncreasing(TreeNode root) {
        if (root == null) return 0;
        if (maxIncrease.containsKey(root))
            return maxIncrease.get(root);
        int max = 1;
        if (root.left != null && root.left.val == root.val + 1) max = Math.max(max, longestIncreasing(root.left) + 1);
        if (root.right != null && root.right.val == root.val + 1) max = Math.max(max, longestIncreasing(root.right) + 1);

        maxIncrease.put(root, max);
        return max;
    }

    private int longestDecreasing(TreeNode root) {
        if (root == null) return 0;
        if (maxDecrease.containsKey(root))
            return maxDecrease.get(root);
        int max = 1;
        if (root.left != null && root.left.val + 1 == root.val) max = Math.max(max, longestDecreasing(root.left) + 1);
        if (root.right != null && root.right.val + 1 == root.val) max = Math.max(max, longestDecreasing(root.right) + 1);

        maxDecrease.put(root, max);
        return max;
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        int max = longestDecreasing(root) + longestIncreasing(root) - 1;
        max = Math.max(max, longestConsecutive(root.left));
        max = Math.max(max, longestConsecutive(root.right));

        return max;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(new Solution().longestConsecutive(node1));
    }
}
