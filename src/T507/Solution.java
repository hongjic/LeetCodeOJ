package T507;

public class Solution {

	public boolean checkPerfectNumber(int num) {
		if (num <= 1) return false;
		int sum = 1;
		for (int i = 2; i <= Math.sqrt((double)num); i ++) 
			if (num % i == 0) {
				sum += i;
				if (i * i != num) sum += num / i;
			}
		return sum == num;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().checkPerfectNumber(25));
	}

}
