package T214;

public class KMPSolution {

	public String shortestPalindrome(String s) {
		String rev = new StringBuilder(s).reverse().toString();
		String l = s + "#" + rev;
		
		// f is equal to the next array in KMP algorithm, finding the max length of
		//  prefix suffix, which means the max overlapping part of the original string and the reverse string 
		int[] f = new int[l.length()];
		for (int i = 1; i < f.length; i ++) {
			int j = f[i - 1];
			while (j > 0 && l.charAt(j) != l.charAt(i))
				j = f[j - 1];
			if (l.charAt(i) == l.charAt(j))
				f[i] = j + 1;
		}
		// concat the non-overlapping part of the reverse string and the original string 
		return rev.substring(0, rev.length() - f[l.length() - 1]) + s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().shortestPalindrome("aacecaaa"));
	}

}
