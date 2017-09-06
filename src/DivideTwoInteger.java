
public class DivideTwoInteger {

	public int divide(int dividend, int divisor) {
		if (divisor == 0) return Integer.MAX_VALUE;
	    boolean positive = true;
	    long d1 = dividend, d2 = divisor;
	    if (d1 < 0) {
	    	d1 = -d1; positive = !positive;
	    }
	    if (d2 < 0) {
	    	d2 = -d2; positive = !positive;
	    }
	    long result = 0;
	    while (d1 >= d2) {
	        long t = 1;
	        while (d2 * t <= d1) t <<= 1;
	        t >>= 1;
	        result += t;
	        d1 -= d2 * t;
	    }
	    if (!positive) result = -result;
	    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return Integer.MAX_VALUE;
	    return (int)result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoInteger d = new DivideTwoInteger();
		System.out.println(d.divide(50, -1));
	}

}
