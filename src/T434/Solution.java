package T434;

public class Solution {

	public int countSegments(String s) {
		int len = s.length();
		char[] arr = s.toCharArray();
		int i = 0, segs = 0;
		while (i < len) {
			while (i < len && arr[i] == ' ') i ++;
			if (i == len) break;
			segs ++;
			while (i < len && arr[i] != ' ') i++;
		}
		return segs;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().countSegments("Hello, my name is John  "));
	}

}
