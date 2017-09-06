package Util;

class SegmentTree {
	
	private int[] nums;
	private Node root;
	
	public static class Node {
		int min, max; //index
		int leftBoundary, rightBoundary;
		Node left, right;
		public Node(int left, int right) {
			leftBoundary = left;
			rightBoundary = right;
		}
	}
	
	public SegmentTree(int[] nums) {
		this.nums = nums;
		root = generateSegmentTree(0, nums.length - 1);
	}
	
	private Node generateSegmentTree(int left, int right) {
		
		if (left > right) return null;
		if (left == right) {
			Node node = new Node(left, left);
			node.min = left;
			node.max = left;
			return node;
		}
		Node root = new Node(left, right);
		int mid = left + (right - left) / 2;
		root.left = generateSegmentTree(left, mid);
		root.right = generateSegmentTree(mid + 1,right);
		
		if (nums[root.left.min] < nums[root.right.min])
			root.min = root.left.min;
		else 
			root.min = root.right.min;
		
		if (nums[root.left.max] > nums[root.right.max])
			root.max = root.left.max;
		else 
			root.max = root.right.max;
		
		return root;
	}
	
	// return an index
	public int getMaxIn(int left, int right) {
		return getMaxIn(root, left, right);
	}
	// return an index
	public int getMinIn(int left, int right) {
		return getMinIn(root, left, right);
	}
	
	private int getMaxIn(Node root, int left, int right) {
		if (root == null || root.leftBoundary > right || root.rightBoundary < left)
			return -1;
		if (root.leftBoundary >= left && root.rightBoundary <= right) 
			return root.max;
		int leftMax = getMaxIn(root.left, left, right);
		int rightMax = getMaxIn(root.right, left, right);
		if (leftMax == -1 || (leftMax != -1 && rightMax != -1 && nums[leftMax] < nums[rightMax]))
			return rightMax;
		else
			return leftMax;
	}
	
	private int getMinIn(Node root, int left, int right) {
 		if (root == null || root.leftBoundary > right || root.rightBoundary < left)
			return -1;
		if (root.leftBoundary >= left && root.rightBoundary <= right)
			return root.min;
		int leftMin = getMinIn(root.left, left, right);
		int rightMin = getMinIn(root.right, left, right);
		if (leftMin == -1  || (leftMin != -1 && rightMin != -1 && nums[leftMin] > nums[rightMin]))
			return rightMin;
		else
			return leftMin;
	}
	
}
