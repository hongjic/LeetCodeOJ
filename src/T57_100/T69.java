package T57_100;

public class T69 {

	public int mySqrt(int x) {
		if (x == 0) return 0;
		long s = 1, t = x;
		while (t - s > 1) {
			long p = (t + s) / 2;
			long pp = p * p;
			if (pp == x)
				return (int) p;
			if (pp < x) 
				s = p;
			else t = p;
		}
		return (int) s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2147483647;
		T69 t69 = new T69();
		System.out.println(t69.mySqrt(x));
	}

}
