package T12_56;
public class T50 {

	private double myPow(double x, int n) {
		if (x==0) return 0;
		if (x==1) return 1;
		if (n==0) return 1;
		boolean flag = true;
		long nn = n;
		if (nn<0) {
			nn = -nn;
			flag = false;
		}
		boolean[] binary = new boolean[33];
		int len = 0;
		while (nn>0) {
			if ((nn & 1) == 1) binary[len] = true;
			nn = nn >> 1;
			len++;
		}
		double pow = x, ans = 1;
		if (binary[0]) ans *= pow;
		for (int i=1; i<len; i++) {
			pow *= pow;
			if (binary[i]) ans *= pow;
		}
		if (flag) return ans;
		return 1.0/ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T50 t50 = new T50();
		double x = 2.00000;
		int n = -2147483648;
		System.out.println(t50.myPow(x, n));
	}

}






//public class Solution {
//    public double myPow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//        if (x == 1) {
//            return 1;
//        }
//        if (x == -1) {
//            return n%2==0?1:-1;
//        }
//        if (n < 0) {
//            x = 1/x;
//            if (n == Integer.MIN_VALUE) {
//                n = -(n + 1);
//            } else {
//                n = Math.abs(n);
//            }
//        }
//        double y = 1;
//        while(n > 1) {
//            if (n % 2 == 0) {
//                x *= x;
//                n /= 2;
//            } else {
//                y *= x;
//                x *= x;
//                n = (n-1)/2;
//            }
//        }
//        return x*y;
//    }
//}