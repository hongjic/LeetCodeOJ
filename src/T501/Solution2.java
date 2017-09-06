package T501;

import java.util.Map;
import java.util.HashMap;

/*
 * This is the uglier solution with space complexity O(n). Hash Map is expensive.
 */
public class Solution2 {

	public int[] findMode(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		traverse(root, map);
		int max = 0, count = 0, i = 0;
		for (int key: map.keySet())
			if (map.get(key) > max) {
				max = map.get(key);
				count = 1;
			}
			else if (map.get(key) == max) count ++;
		int[] res = new int[count];
		for (int key: map.keySet())
			if (map.get(key) == max)
				res[i ++] = key;
		return res;
	}
	
	private void traverse(TreeNode root, Map<Integer, Integer> map) {
		if (root == null) return;
		map.put(root.val, map.getOrDefault(root.val, 0) + 1);
		traverse(root.left, map);
		traverse(root.right, map);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(6);
		TreeNode node8 = new TreeNode(6);
		TreeNode node9 = new TreeNode(6);
		node5.left = node3;
		node3.left = node2;
		node2.left = node1;
		node3.right = node4;
		node5.right = node8;
		node8.left = node7;
		node8.right = node9;
		node7.left = node6;
		int[] res = new Solution2().findMode(node5);
		for (int i = 0; i < res.length; i ++)
			System.out.print(res[i] + ", ");
	}

}
