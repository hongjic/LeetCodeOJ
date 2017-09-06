package T199;

import java.util.List;
import java.util.ArrayList;

public class Solution2 {

	
	// this solution is more concise, although time complexity is the same.
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}
	
	private void rightView(TreeNode curr, List<Integer> result, int currDepth) {
		if (curr == null) return;
		if (currDepth == result.size()) result.add(curr.val);
		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);
	}
	
	public static void main(String[] args) {
	}

}
