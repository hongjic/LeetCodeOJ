package T57_100;

public class T58 {

	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int len = s.length(), i = len - 1, count = 0;
		while (i >= 0 && s.charAt(i) == ' ') i --;
		while (i >= 0 && s.charAt(i) != ' ') {
			count ++;
			i --;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T58 t58 = new T58();
		String s = "    ";
		System.out.println(t58.lengthOfLastWord(s));
		
	}

}
