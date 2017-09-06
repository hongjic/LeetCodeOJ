package T553;

public class Solution {
	
	private static final int MIN = 0;
	private static final int MAX = 1;
	private static final int invertMode(int mode) {
		return 1 - mode;
	}
	private static final boolean better(double v1, double v2, int mode) {
		if (mode == MIN && v1 < v2) return true;
		if (mode == MAX && v1 > v2) return true;
		return false;
	}
	
	private class Exp {
		String expr;
		double value;
		public Exp(String e, double v) {
			expr = e;
			value = v;
		}
	}

//	private Exp minimalDivision(int[] nums, int start, int end) {
//		if (start == end) return new Exp(String.valueOf(nums[start]), (double)nums[start]);
//		if (start + 1 == end) return new Exp(String.valueOf(nums[start]) + '/' + String.valueOf(nums[end]), (double)nums[start] / nums[end]);
//		double min = Double.MAX_VALUE;
//		String expr = null;
//		for (int d = start; d < end; d ++) {
//			Exp part1 = minimalDivision(nums, start, d);
//			Exp part2 = optimalDivision(nums, d + 1, end);
//			if (part1.value / part2.value < min) {
//				min = part1.value / part2.value;
//				expr = part1.expr + '/' + (end == d + 1 ? part2.expr : '(' + part2.expr + ')');
//			} 
//		}
//		return new Exp(expr, min);
//	}
//	
//	private Exp optimalDivision(int[] nums, int start, int end) {
//		if (start == end) return new Exp(String.valueOf(nums[start]), (double)nums[start]);
//		if (start + 1 == end) return new Exp(String.valueOf(nums[start]) + '/' + String.valueOf(nums[end]), (double)nums[start] / nums[end]);
//		double max = 0;
//		String expr = null;
//		for (int d = start; d < end; d ++) {
//			Exp part1 = optimalDivision(nums, start, d);
//			Exp part2 = minimalDivision(nums, d + 1, end);
//			if (part1.value / part2.value > max) {
//				max = part1.value / part2.value;
//				expr = part1.expr + '/' + (end == d + 1 ? part2.expr : '(' + part2.expr + ')');
//			}
//		}
//		return new Exp(expr, max);
//	}
	
	private Exp optimalDivision(int[] nums, int start, int end, int mode) {
		if (start == end) return new Exp(String.valueOf(nums[start]), (double)nums[start]);
		if (start + 1 == end) return new Exp(String.valueOf(nums[start]) + '/' + String.valueOf(nums[end]), (double)nums[start] / nums[end]);
		double value = mode == MIN ? Double.MAX_VALUE : 0;
		String expr = null;
		for (int d = start; d < end; d ++) {
			Exp part1 = optimalDivision(nums, start, d, mode);
			Exp part2 = optimalDivision(nums, d + 1, end, invertMode(mode));
			if (better(part1.value / part2.value, value, mode)) {
				value = part1.value / part2.value;
				expr = part1.expr + '/' + (end == d + 1 ? part2.expr : '(' + part2.expr + ')');
			}
		}
		return new Exp(expr, value);
	}
	
	
	public String optimalDivision(int[] nums) {
		String res = optimalDivision(nums, 0, nums.length - 1, MAX).expr;
		if (res.charAt(0) == '(') return res.substring(1, res.length() - 2);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = new Solution().optimalDivision(new int[]{6,2,3,4,5});
		System.out.println(res);
	}

}
