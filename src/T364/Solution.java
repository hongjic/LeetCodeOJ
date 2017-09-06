package T364;

import java.util.List;

public class Solution {

	private int helper(List<NestedInteger> nestedList, Integer depth) {
		int sum = 0;
		for (int i = 0; i < nestedList.size(); i ++) {
			NestedInteger nested = nestedList.get(i);
			if (nested.isInteger())
				sum += depth * nested.getInteger();
			else
				sum += helper(nested.getList(), depth - 1);
		}
		return sum;
	}
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
		int maxDepth = getDepth(nestedList);
		return helper(nestedList, maxDepth);
	}
	
	private int getDepth(List<NestedInteger> nestedList) {
		int max = 0;
		for (int i = 0; i < nestedList.size(); i ++)
			if (nestedList.get(i).isInteger())
				max = Math.max(max, 1);
			else 
				max = Math.max(max, getDepth(nestedList.get(i).getList()) + 1);
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
