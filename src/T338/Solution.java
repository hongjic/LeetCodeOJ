package T338;

public class Solution {

	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		res[0] = 0;
		int i = 1, j = 1;
		while (i <= num) {
			res[i] = res[i - j] + 1;
			i ++;
			if (i == j * 2) j *= 2;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 2;
		int[] res = new Solution().countBits(num);
		for (int i = 0; i <= num; i ++ )
			System.out.print(res[i] + ", ");
	}

}
