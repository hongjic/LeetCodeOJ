package T652;

import apple.laf.JRSUIUtils;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    private String postOrderTraversal(TreeNode node, Map<String, Integer> treeCount, List<TreeNode> res) {
        if (node == null) return "null";
        String code = String.join(",",
                String.valueOf(node.val), postOrderTraversal(node.left, treeCount, res), postOrderTraversal(node.right, treeCount, res));
        if (treeCount.containsKey(code) && treeCount.get(code) == 1)
            res.add(node);
        treeCount.put(code, treeCount.getOrDefault(code, 0) + 1);
        return code;
    }


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        postOrderTraversal(root, new HashMap<>(), res);
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> res = new Solution().findDuplicateSubtrees(null);
    }
}
