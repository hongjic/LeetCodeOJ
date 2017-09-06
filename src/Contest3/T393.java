package Contest3;


public class T393 {

	private static boolean helper(int[] data, int start) {
		if (data.length==start) return true;
		int head = data[start];
		int x = 0;
		while ( ((head<<x) & 128)!=0 ) {
			x++;
			if (x>4) return false;
		}
		if (x==1) return false;
		if (x==0) x++; //此时x为character byte数
		for (int i=start+1; i<start+x; i++)
			//if data[i]以10开头
			if (i>=data.length || (data[i] & 192)!=128)
				return false;
		return helper(data, start+x);
	}
	
	private static boolean validUtf8(int[] data) {
		return helper(data, 0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {197, 130, 197, 130, 197, 130, 1, 197, 130, 1, 197, 130, 235, 140, 4, 197, 130, 1};
		System.out.println( validUtf8(a)  );
	}

}
