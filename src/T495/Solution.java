package T495;

public class Solution {

	public int findPosisonedDuration(int[] timeSeries, int duration) {
		int sum = 0, max = 0;
		if (timeSeries.length == 0) return sum;
		for (int i = 0; i < timeSeries.length; i ++) {
			if (timeSeries[i] <= max) {
				int newmax = Math.max(max, timeSeries[i] + duration);
				sum += newmax - max;
				max = newmax;
			}
			else {
				max = timeSeries[i] + duration;
				sum += duration;
			}
		}
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] timeSeries = new int[] {1,2};
		int duration = 2;
		System.out.println(new Solution().findPosisonedDuration(timeSeries, duration));
	}

}
