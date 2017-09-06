package T157;

class Reader4 {
	int read4(char[] buf){
		return 0;
	};
}

public class Solution extends Reader4{

	private char[] cache = new char[4];
	
	public int read(char[] buf, int n) {
		int count = 0;
		int num = 0, i = 0;
		while (count < n) {
			if (i == num) {
				num = read4(cache);
				i = 0;
				if (num == 0) break;
				continue;
			}
			buf[count ++] = cache[i ++];
		}
		return count;
	}

}
