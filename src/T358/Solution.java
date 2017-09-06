package T358;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public String rearrangeString(String str, int k) {
		if (k <= 1) return str;
		char[] c = str.toCharArray();
		int[][] cnt = new int[26][2];
		int len = str.length();
		for (int i = 0; i < 26; i ++) cnt[i][0] = i;
		for (int i = 0; i < len; i ++) cnt[c[i] - 'a'][1] ++;
		Arrays.sort(cnt, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return b[1] - a[1];
			}
		});
		
		int blocks = (len - 1) / k + 1;
		int[] index = new int[blocks]; // current filling cell index in each block
		char[] res = new char[len];
		int i = 0; // current filling block number
		for (int ch = 0; ch < 26; ch ++)
			if (cnt[ch][1] > 0) {
				char cur = (char)(cnt[ch][0] + 'a');
				if (cnt[ch][1] > blocks) return ""; // if number of this character is bigger than the size of blocks.
				for (int j = 0; j < cnt[ch][1]; j ++) {
					while (index[i] >= blockSize(i, k, len))
						i = (i + 1) % blocks; // get the next block in cycle.
					if (index[i] > 0 && res[i * k + index[i] - 1] == cur) return ""; // same character exists in the same character.
					res[i * k + index[i]] = cur;
					index[i] += 1;
					i = (i + 1) % blocks;
				}
			}
			
		return new String(res);
	}
	
	private int blockSize(int blockNo, int blockSize, int len) {
		return Math.min(len - blockNo * blockSize, blockSize);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().rearrangeString("aabbcc", 4));
	}

}
