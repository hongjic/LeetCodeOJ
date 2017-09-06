package T57_100;

public class T70 {

	public int climbStairs(int n) {
		if (n == 0 || n == 1) return 1;
		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < n + 1; ++ i) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		T70 t70 = new T70();
		System.out.println(t70.climbStairs(n));
	}

}
