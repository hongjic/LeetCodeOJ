package T464;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Solution {

	private Map<Integer, Boolean> result;
	private boolean[] leftNums;
	private int maxNum;
	
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
			return false;
		if (desiredTotal <= 0) 
			return true;
		this.maxNum = maxChoosableInteger;
		result = new HashMap<Integer, Boolean>();
		leftNums = new boolean[maxNum + 1];
		for (int i = 1; i <= maxNum; i ++)
			leftNums[i] = true;
		return recursive(desiredTotal);
	}
	
	private boolean recursive(int desiredTotal) {
		if (desiredTotal <= 0)
			return false;
		int key = parse(leftNums);
		if (!result.containsKey(key)) { 
			for (int i = 1; i <= maxNum; i ++)
				if (leftNums[i]) {
					leftNums[i] = false;
					if (!recursive(desiredTotal - i)) {
						result.put(key, true);
						leftNums[i] = true;
						return true;
					}
					leftNums[i] = true;
				}
			result.put(key, false);
		}
		return result.get(key);
	}
	
	private int parse(boolean[] leftNums) {
		int sum = 0, m = 1;
		for (int i = 1; i <= maxNum; i ++) {
			if (leftNums[i]) sum += m * i;
			m *= 2;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().canIWin(10, 40));
	}

}
