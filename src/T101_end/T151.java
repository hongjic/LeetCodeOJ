package T101_end;

public class T151 {

	private String reverseWords(String s) {
		StringBuffer sb = new StringBuffer();
		StringBuffer sub = new StringBuffer();
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) == ' ') {
				sb.insert(0, ' ');
				while (i < s.length() && s.charAt(i) == ' ') 
					i ++;
			}
			while (i < s.length() && s.charAt(i) != ' ') {
				sub.append(s.charAt(i));
				i ++;
			}
			sb.insert(0, sub);
			sub = new StringBuffer();
		}
		return sb.toString().trim();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T151 t151 = new T151();
		System.out.println(t151.reverseWords(" the sky is blue    "));
		
	}

}
