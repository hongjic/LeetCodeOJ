package T12_56;
public class T29 {

	private static int divide(int dividend, int divisor) {
		if (divisor==0)
			return Integer.MAX_VALUE;
		long a = (long)dividend, b = (long)divisor;
		boolean flag = true;
		if (((b>>31)^(a>>31))==0xFFFFFFFF)
			flag = false;
		if (a>>31 == -1) a = ~a+1;
		if (b>>31 == -1) b = ~b+1;
		long sum = 0;
		while (a>=b) {
			int x=0;
			long d=1;
			while (b<<x <= a) {
				x++;
				d = d<<1;
			}
			x--; 
			sum += d>>1;
			a = a-(b<<x);
		}
		if (!flag) sum = ~sum+1;
		if (sum>=Integer.MIN_VALUE && sum<=Integer.MAX_VALUE)
			return (int)sum;
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483648,-1));
	}

}



//public class Solution {
//    public int divide(int a, int b) {
//        if (b == 0)
//            return Integer.MAX_VALUE;
//        //由于Integer.MINVALUE的特殊性(其补码是它本身)，不得不将int型转为long型
//        long dividend = (long)a;
//        long divisor = (long)b;
//        //符号位做和，-1表示结果为负，否则结果为正数
//        long sign = (dividend >> 31) + (divisor >> 31);
//        dividend = (dividend >> 31) == 0 ? dividend : (~dividend + 1);
//        divisor = (divisor >> 31) == 0 ? divisor : (~divisor + 1);
//        //初始判断，被除数小，直接返回0
//        if(divisor > dividend)
//            return 0;
//        //开始递归
//        long quotient = recurse(dividend, divisor, divisor, 1);
//        //给商加上符号
//        quotient = (sign == -1) ? (~quotient + 1) : quotient;
//        //判断是否溢出，如a=Integer.MINVALUE,b=-1结果是溢出的
//        if(quotient >= Integer.MIN_VALUE && quotient <= Integer.MAX_VALUE)
//            return (int)quotient;
//        else
//            return Integer.MAX_VALUE;
//    }
//    /*
//     * 大致思路：
//     * 除数依次左移一位(乘2)，直至大于被除数
//     * 回退，判断，若差小于初始除数，结束，否则被除数置为两者之差，除数为初始数；
//     * 例如，(7,2,2,1)->(7,4,2,2)->(7,8,2,4)->(3>2)->(3,2,2,1)+2->(3,4,2,1)+2->(1<2)->return 1+2=3;
//     */
//    public long recurse(long dividend, long divisor, long init, long quotient){
//        if(dividend > divisor){
//            return recurse(dividend, divisor << 1, init, quotient << 1);
//        } else if(dividend == divisor){
//            return quotient;
//        } else{
//            if(dividend-(divisor >> 1) < init)
//                return quotient>>1;
//            else
//                return recurse(dividend - (divisor >> 1), init, init, 1) + (quotient >> 1);
//        }
//    }
//}