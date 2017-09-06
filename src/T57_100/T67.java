package T57_100;

public class T67 {

	private String addBinary(String a, String b) {
		StringBuffer res = new StringBuffer();
		int ia = a.length() - 1,
			ib = b.length() - 1;
		int add = 0;
		while (ia >= 0 || ib >=0 || add > 0) {
			int cur = (ia >= 0 ? a.charAt(ia) - 48 : 0) + (ib >= 0 ? b.charAt(ib) - 48 : 0) + add; 
			if (cur >= 2) {
				cur -= 2;
				add = 1;
			}
			else add = 0;
			-- ia;
			-- ib;
			res.insert(0, (char)(cur + 48));
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "111110";
		String b = "110011";
		T67 t67 = new T67();
		System.out.println(t67.addBinary(a, b));
	}

}
