package T339;

import java.util.List;
import java.util.ArrayList;

public class Solution2 {

	public int depthSumInverse(List<NestedInteger> nestedList) {
		int unweighted = 0, weighted = 0;
		while (!nestedList.isEmpty()) {
			List<NestedInteger> nextLevel = new ArrayList<>();
			for (int i = 0; i < nestedList.size(); i ++) {
				if (nestedList.get(i).isInteger())
					unweighted += nestedList.get(i).getInteger();
				else
					nextLevel.addAll(nestedList.get(i).getList());
			}
			weighted += unweighted;
			nestedList = nextLevel;
		}
		return weighted;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
