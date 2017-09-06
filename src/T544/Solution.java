package T544;

public class Solution {

	private StringBuilder sb = new StringBuilder();
	
	public String findContestMatch(int n) {
		int k = 1, nn = 2;
		while (nn < n) {
			nn *= 2; k ++;
		}
		generateBTree(n, k, n * 2, 1);
		return sb.toString();
	}
	
	private void generateBTree(int root, int level, int sum, int minus) {
		if (level == 0) return;
		if (level == 1) {
			sb.append('(').append(sum - minus - root).append(',').append(root).append(')');
			return;
		}
		sb.append('(');
		//left
		generateBTree(root, level - 1, sum - minus, minus * 2);
		sb.append(',');
		//right
		generateBTree(sum - minus - root, level - 1, sum - minus, minus * 2);
		sb.append(')');
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().findContestMatch(4096));
	}

}
