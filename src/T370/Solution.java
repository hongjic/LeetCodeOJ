package T370;

public class Solution {

	public int[] getModifiedArray(int length, int[][] updates) {
		int[] res = new int[length];
		for (int i = 0; i < updates.length; i ++) {
			res[updates[i][0]] += updates[i][2];
			if (updates[i][1] + 1 < length)
				res[updates[i][1] + 1] -= updates[i][2];
		}
		for (int i = 1; i < length; i ++)
			res[i] += res[i - 1];
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] updates = new int[][] {
				{1,3,2},
				{2,4,3},
				{0,2,-2}
		};
		int[] res = new Solution().getModifiedArray(5, updates);
		for (int i = 0; i < res.length; i ++)
			System.out.print(res[i] + ", ");
	}

}
