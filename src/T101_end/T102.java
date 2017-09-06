package T101_end;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T102 {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) { val = x; }
	}
	
	private List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        List<List<TreeNode>> bfs = new ArrayList<List<TreeNode>>();
        int level = 0;
        int index = 0;
        bfs.add(Arrays.asList(root));
        result.add(Arrays.asList(root.val));
        List<TreeNode> curLine = new ArrayList<TreeNode>();
        List<Integer> curResult = new ArrayList<Integer>();
        while (level < bfs.size()) {
            TreeNode cur = bfs.get(level).get(index);
            if (cur.left != null) {
                curLine.add(cur.left);
                curResult.add(cur.left.val);
            }
            if (cur.right != null) {
            	curLine.add(cur.right);
            	curResult.add(cur.right.val);
            }
            index ++;
            if (index == bfs.get(level).size()) {
                index = 0;
                level ++;
                if (curLine.size() > 0) {
                	bfs.add(curLine);
                	result.add(curResult);
                }
                curLine = new ArrayList<TreeNode>();
                curResult = new ArrayList<Integer>();
            }
        }
        return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(3),
				node2 = new TreeNode(9),
				node3 = new TreeNode(20),
				node4 = new TreeNode(15),
				node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		T102 t102 = new T102();
		List<List<Integer>> result = t102.levelOrder(node1);
		for (int i = 0; i < result.size(); i ++) {
			for (int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j) + " ");
			System.out.println();
		}
	}

}
