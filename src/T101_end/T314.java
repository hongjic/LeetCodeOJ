package T101_end;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;


public class T314 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) { val = x;}
	}
	
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		List<Integer> column = new ArrayList<Integer>();
		nodes.add(root);
		column.add(0);
		int p = 0, min = 0;
		while (p < nodes.size()) {
			TreeNode curNode = nodes.get(p);
			int curColumn = column.get(p);
			if (curColumn < min) min = curColumn;
			if (map.containsKey(curColumn)) {
				map.get(curColumn).add(curNode.val);
			}
			else {
				List<Integer> newColumn = new ArrayList<Integer>();
				newColumn.add(curNode.val);
				map.put(curColumn, newColumn);
			}
			if (curNode.left != null) {
				nodes.add(curNode.left);
				column.add(curColumn - 1);
			}
			if (curNode.right != null) {
				nodes.add(curNode.right);
				column.add(curColumn + 1);
			}
			p ++;
		}
		// map into list<list>
		while (map.containsKey(min)) {
			result.add(map.get(min));
			min ++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T314 t314 = new T314();
		TreeNode node3 = new TreeNode(3),
				node9 = new TreeNode(9),
				node8 = new TreeNode(8),
				node4 = new TreeNode(4),
				node0 = new TreeNode(0),
				node1 = new TreeNode(1),
				node7 = new TreeNode(7);
		node3.left = node9;
		node3.right = node8;
		node9.left = node4;
		node9.right = node0;
		node8.left = node1;
		node8.right = node7;
		List<List<Integer>> result = t314.verticalOrder(node3);
		for (int i = 0; i < result.size(); i ++) {
			for (int j = 0; j < result.get(i).size(); j ++)
				System.out.print(result.get(i).get(j) + " ");
			System.out.println();
		}
	}

}
