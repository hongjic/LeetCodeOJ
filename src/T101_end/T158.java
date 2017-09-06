package T101_end;

class Reader4 {
	int read4(char[] buf){
		return 0;
	};
}

public class T158 extends Reader4 {
	 /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] cache = new char[4]; 
    private int p = 0;
    private int num = 0;
    
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (p < num) {
                buf[index ++] = cache[p ++];
            }
            else {
                p = 0;
                num = read4(cache);
                if (num == 0) break;
            }
        }
        return index;
    }

}
