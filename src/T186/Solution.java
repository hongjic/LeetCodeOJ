package T186;

public class Solution {

	public void reverseWords(char[] s) {
		int len = s.length;
		if (len == 0) return;
		reverse(s, 0, len - 1);
		int fast = 0, slow = 0;
		while (fast < len) {
			while (fast < len && s[fast] != ' ') fast ++;
			reverse(s, slow, fast - 1);
			fast ++;
			slow = fast;
		}
	}
	
	private void reverse(char[] s, int left, int right) {
		int mid = left + (right - left) / 2;
		for (int i = left; i <= mid; i ++) {
			char t = s[i];
			s[i] = s[right - i + left];
			s[right - i + left] = t;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = "".toCharArray();
		new Solution().reverseWords(s);
		System.out.println(String.valueOf(s));
	}

}
