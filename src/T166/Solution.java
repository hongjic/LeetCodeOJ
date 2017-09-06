package T166;

import java.util.Map;
import java.util.HashMap;

public class Solution {

	public String fractionToDecimal(int numerator, int denominator) {
		long d1 = numerator, d2 = denominator;
		boolean positive = true;
		if (d1 < 0) {
			d1 = - d1;
			positive = !positive;
		}
		if (d2 < 0) {
			d2 = - d2;
			positive = !positive;
		}
		long beforeP = d1 / d2;
		d1 = d1 % d2 * 10;
		StringBuilder afterP = new StringBuilder();
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		int index = 0;
		while (!map.containsKey(d1) && d1 != 0) {
			map.put(d1, index);
			afterP.append(d1 / d2);
			d1 = d1 % d2 * 10;
			index ++;
		}
		if (d1 != 0) {
			afterP.insert(map.get(d1), "(");
			afterP.append(")");
		}
		if (afterP.length() == 0) return (positive ? "" : beforeP == 0 ? "" : "-") + String.valueOf(beforeP);
		return (positive ? "" : "-") + String.format("%d.%s", beforeP, afterP);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().fractionToDecimal(-1, -2147483648));
	}

}
