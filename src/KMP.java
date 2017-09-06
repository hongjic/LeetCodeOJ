
public class KMP {

	public static void KMPSearch(String pattern, String st) {
		int m = pattern.length();
		int n = st.length();
		int[] lps = new int[m];
		int j = 0;
		
		computeLPSArray(pattern, m, lps);
		
		int i = 0;
		while (i < n) {
			if (pattern.charAt(j) == st.charAt(i)) {
				j ++;
				i ++;
				if (j == m) {
					System.out.println("Found pattern " + "at index " + (i - j));
					j = lps[j - 1];
				}
			} else {
				if (j != 0) j = lps[j - 1];
				else i ++;
			}
		}
	}
	
	private static void computeLPSArray(String pattern, int m, int[] lps) {
		int len = 0;
		int i = 1;
		lps[0] = 0;
		
		while (i < m) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len ++;
				lps[i] = len;
				i ++;
			} else {
				if (len != 0) len = lps[len - 1];
				else {
					lps[i] = len;
					i ++;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "ABAB";
		String st = "ABABDABACDABABCABAB";
		KMPSearch(pattern, st);
	}

}
