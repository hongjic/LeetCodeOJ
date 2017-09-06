/**
 * 
 */
package T57_100;

/**
 * @author chenhongji
 *
 */
public class T91 {

	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int len = s.length();
		int[] f = new int[len + 1];
		f[0] = 1; 
		f[1] = 1;
		if (s.charAt(0) == '0') return 0;
		for (int i = 0; i < len - 1; ++ i) 
			if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) -48 <= 6)) {
				f[i + 2] = f[i];
				if (s.charAt(i + 1) != '0')
					f[i + 2] += f[i + 1];
			}
			else if (s.charAt(i + 1) == '0')
				return 0;
			else
				f[i + 2] = f[i + 1];
		return f[len];
	}
	
	public static void main(String[] args) {
		T91 t91 = new T91();
		System.out.println(t91.numDecodings("22023277"));
	}

}
