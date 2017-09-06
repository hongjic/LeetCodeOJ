package T339;

import java.util.List;

public class Solution {

	private int helper(List<NestedInteger> nestedList, Integer depth) {
		int sum = 0;
		for (int i = 0; i < nestedList.size(); i ++) {
			NestedInteger nested = nestedList.get(i);
			if (nested.isInteger())
				sum += depth * nested.getInteger();
			else
				sum += helper(nested.getList(), depth + 1);
		}
		return sum;
	}
	
	public int depthSum(List<NestedInteger> nestedList) {
		return helper(nestedList, 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
