package Util;

public class KMP {
	
	private int[] generateNext(String pattern) {
		int lenp = pattern.length();
		int[] next = new int[lenp];
		next[0] = -1;
		for (int i = 1; i < lenp; i ++) {
			int j = next[i - 1];
			while (pattern.charAt(j + 1) != pattern.charAt(i) && j >= 0)
				j = next[j];
			if (pattern.charAt(i) == pattern.charAt(j + 1))
				next[i] = j + 1;
			else 
				next[i] = -1;
		}
		return next;
	}

	public int indexOf(String target, String pattern) {
		int lent = target.length();
		int lenp = pattern.length();
		int[] next = generateNext(pattern);
		int index_t = 0, index_p = 0;
		while (index_t < lent && index_p < lenp) {
			if (target.charAt(index_t) == pattern.charAt(index_p)) {
				index_t ++;
				index_p ++;
			}
			else {
				if (index_p == 0) index_t ++;
				else index_p = next[index_p - 1] + 1;
			}
		}
		return index_p == lenp ? (index_t - lenp) : -1; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMP solution = new KMP();
		String target = "babcbabcabcaabcabcabcacabc";
		String pattern = "abcabcacab";
		System.out.println(solution.indexOf(target, pattern));
	}

}
