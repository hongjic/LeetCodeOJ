package T662;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> nodeList = new LinkedList<>();
        Queue<int[]> posList = new LinkedList<>();
        nodeList.offer(root);
        posList.offer(new int[]{0, 0});
        int level = 0, first = 0, max = 0;

        while (!nodeList.isEmpty()) {
            TreeNode node = nodeList.poll();
            int[] pos = posList.poll();
            if (pos[0] == level) max = Math.max(max, pos[1] - first + 1);
            else {
                level = pos[0];
                first = pos[1];
            }
            if (node.left != null) {
                nodeList.offer(node.left);
                posList.offer(new int[] {pos[0] + 1, pos[1] * 2});
            }
            if (node.right != null) {
                nodeList.offer(node.right);
                posList.offer(new int[] {pos[0] + 1, pos[1] * 2 + 1});
            }
        }

        return max;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        System.out.println(new Solution().widthOfBinaryTree(null));

    }
}
