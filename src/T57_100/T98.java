package T57_100;

import java.util.ArrayList;
import java.util.List;

public class T98 {
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) { val = x; }
	}
	
	private boolean getMidOrder(TreeNode root, List<Integer> midOrder) {
		if (root == null) return true;
		if (!getMidOrder(root.left, midOrder)) 
			return false;
		if (midOrder.size() > 0 && root.val <= midOrder.get(midOrder.size() - 1))
			return false;
		midOrder.add(root.val);
		return getMidOrder(root.right, midOrder);
	}
	
	public boolean isValidBST_v1(TreeNode root) {
		List<Integer> midOrder = new ArrayList<Integer>();
		return getMidOrder(root, midOrder);
	}
	
	public static void main(String[] args) {
		T98 t98 = new T98();
		TreeNode node1 = new TreeNode(4),
				node2 = new TreeNode(3),
				node3 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		System.out.println(t98.isValidBST_v1(node1));
	}

}




//
//public class Solution {
//    
//    private void getMidOrder(TreeNode root, List<Integer> midOrder) {
//		if (root == null) return ;
//		getMidOrder(root.left, midOrder);
//		midOrder.add(root.val);
//		getMidOrder(root.right, midOrder);
//	}
//    
//    public boolean isValidBST(TreeNode root) {
//        List<Integer> midOrder = new ArrayList<Integer>();
//		getMidOrder(root, midOrder);
//		int len = midOrder.size();
//		for (int i = 1; i < len; i ++)
//			if (midOrder.get(i) <= midOrder.get(i - 1))
//				return false;
//		return true;
//    }
//}