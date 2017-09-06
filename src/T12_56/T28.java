package T12_56;
public class T28 {
	
	private static int[] next(String needle) {
		int len = needle.length();
		int[] next = new int[len];
		if (len>0) next[0] = -1;
		int k = -1, j= 0;
		while (j<len-1) {
			//needle[k]为前缀的最后一位 , needle[j]为后缀最后一位
			if (k==-1 || needle.charAt(j)==needle.charAt(k)) {
				k++;
				j++;
				next[j] = k;
			}
			else 
				k = next[k];
		}
		return next;
	}
	
	private static int strStr(String haystack, String needle) {
		int[] next = next(needle);
		int i = 0, j= 0;
		int len_h = haystack.length(),
			len_n = needle.length();
		while (i<len_h && j<len_n) {
			//如果 j = -1 或者当前字符匹配成功 两个指针都加1
			//j = -1 是因为next数组中next[0]=-1 这么设定的作用是当patern[0..j]中不存在相同前缀后缀时
			//j指针需要回归0，i＋1 ,即从下一个位置开始重新匹配
			if (j==-1 || haystack.charAt(i)==needle.charAt(j)) {
				i++;
				j++;
			}
			else 
				j = next[j];
		}
		if (j<len_n) 
			return -1;
		return i-j;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("", ""));
	}

}