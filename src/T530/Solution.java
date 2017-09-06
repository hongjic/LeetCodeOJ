package T530;

import java.util.Iterator;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    private static class BSTIterator implements Iterator<TreeNode>{

        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            TreeNode node = root;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public TreeNode next() {
            TreeNode res = stack.pop();
            TreeNode node = res.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return res;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        BSTIterator iter = new BSTIterator(root);
        TreeNode pre = iter.next();
        int min = Integer.MAX_VALUE;

        while (iter.hasNext()) {
            TreeNode node = iter.next();
            if (node.val - pre.val < min)
                min = node.val - pre.val;
            pre = node;
        }

        return min;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        node1.right = node3; node3.left = node2;
        System.out.println(new Solution().getMinimumDifference(node1));
    }
}
