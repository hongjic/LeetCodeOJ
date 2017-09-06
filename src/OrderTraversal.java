import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
    Binary Tree level order traversal
 */


class OrderTraversal {
	public static class TreeNode {
	    int val;
	    TreeNode left, right;
	    TreeNode(int val) { this.val = val;}
	}
  
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        List<TreeNode> preLineNode = new ArrayList<TreeNode>();
        List<TreeNode> curLineNode = new ArrayList<TreeNode>();
        preLineNode.add(root);
        List<Integer> curLineResult = new ArrayList<Integer>();
        int i = 0;
        while (i < preLineNode.size()) {
            TreeNode preNode = preLineNode.get(i);
            curLineResult.add(preNode.val);
            if (preNode.left != null)
                curLineNode.add(preNode.left);
            if (preNode.right != null)
                curLineNode.add(preNode.right);
            i ++;
            if (i == preLineNode.size()) {
                preLineNode = curLineNode;
                curLineNode = new ArrayList<TreeNode>();
                result.add(curLineResult);
                curLineResult = new ArrayList<Integer>();
                i = 0;
            }
        }
        return result;
    }
    
    public static class DepNode{
        TreeNode node;
        int depth;
        DepNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    public List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<DepNode> queue = new ArrayList<DepNode>();
        queue.add(new DepNode(root, 0));
        int i = 0, column = 0;
        while (i < queue.size()) {
            DepNode cur = queue.get(i);
            if (map.containsKey(cur.depth)) {
                map.get(cur.depth).add(cur.node.val);
            }
            else {
            	List<Integer> list = new ArrayList<Integer>();
            	list.add(cur.node.val);
                map.put(cur.depth, list);
            }
            if (cur.depth < column) column = cur.depth;
            if (cur.node.left != null) 
                queue.add(new DepNode(cur.node.left, cur.depth - 1));
            if (cur.node.right != null)
                queue.add(new DepNode(cur.node.right, cur.depth + 1));
            i ++;
        }
        while (map.containsKey(column)) {
            result.add(map.get(column));
            column ++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        OrderTraversal sol = new OrderTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        List<List<Integer>> result = sol.levelOrderTraversal(node1);
        for (int i = 0; i < result.size(); i ++) {
            for (int j = 0; j < result.get(i).size(); j ++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println(result.size());
        System.out.println("Vertial order traversal");
        List<List<Integer>> vertical = sol.verticalOrderTraversal(node1);
        for (int i = 0; i < vertical.size(); i ++) {
            for (int j = 0; j < vertical.get(i).size(); j ++) 
                System.out.print(vertical.get(i).get(j) + " ");
            System.out.println();
        }
    }
}
