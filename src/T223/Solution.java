package T223;

public class Solution {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		long width = (long)Math.min(C, G) - Math.max(A, E);
		if (width < 0) width = 0;
		long height = (long)Math.min(D, H) - Math.max(B, F);
		if (height < 0) height = 0;
		return (int)((C - A) * (D - B) + (G - E) * (H - F) - width * height);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
	}

}
