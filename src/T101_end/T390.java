package T101_end;
public class T390 {

	private static int lastRemaining(int n) {
		if (n==1) return 1;
		if (n%2==0)
			return n-2*(lastRemaining(n/2)-1);
		else
			return n-1-2*(lastRemaining(n/2)-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lastRemaining(16));
	}

}
