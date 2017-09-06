package T315;

import java.util.List;
import java.util.LinkedList;

class Node {
	Node left, right;
	int val, leftSum, dup;
	Node (int x) {
		val = x; leftSum = 0; dup = 1;
	}
}

public class Solution {

	public List<Integer> countSmaller(int[] nums) {
		int len = nums.length;
		LinkedList<Integer> result = new LinkedList<Integer>();
		if (len == 0) return result;
		Node root = new Node(nums[len -  1]);
		result.addFirst(0);
		for (int i = len - 2; i >= 0; i --)
			result.addFirst(addNode(root, nums[i]));
		return result;
	}
	
	private int addNode(Node root, int val) {
		int sum = 0;
		Node node = root, pre = null;
		while (node != null && node.val != val) {
			if (val < node.val) {
				node.leftSum ++;
				pre = node;
				node = node.left;
			}
			else {
				sum += node.leftSum + node.dup;
				pre = node;
				node = node.right;
			}
		}
		if (node == null) {
			if (val < pre.val) pre.left = new Node(val);
			else pre.right = new Node(val);
		}
		else {
			sum += node.leftSum;
			node.dup ++;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = new Solution().countSmaller(new int[]{7,3,2,2,6,1});
		for (int i = 0; i < result.size(); i ++)
			System.out.print(result.get(i) + " ");
	}

}
