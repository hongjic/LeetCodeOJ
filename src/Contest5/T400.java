package Contest5;

public class T400 {

	private static int findNthDigit(int n) {
		long b = 9, t = 1;
		while (n > b * t) {
			n -= b * t;
			b = b * 10;
			t = t + 1;
		}
		long m = n / t, l = n - t * m;
		if (l == 0)
			return (int) ((b/9+m-1)%10); //第m个t位数的个位
		else{
			String s = String.valueOf(b/9+m);
			return s.charAt((int)(l-1))-48;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2147483647;
		System.out.println(findNthDigit(n));
	}

}
