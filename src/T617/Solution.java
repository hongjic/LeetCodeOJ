package T617;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) {
            t2.left = mergeTrees(t2.left, null);
            t2.right = mergeTrees(t2.right, null);
            return t2;
        }
        if (t2 == null) {
            t1.left = mergeTrees(t1.left, null);
            t1.right = mergeTrees(t1.right, null);
            return t1;
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }
}