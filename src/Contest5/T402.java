package Contest5;

public class T402 {

	private static String removeKdigits(String num, int k) {
		if (num.length() == k)
			return "0";
		StringBuffer sb = new StringBuffer();
		int count = 0;
		char[] carr = num.toCharArray();
		for (char c : carr) {
			while (sb.length() != 0 && sb.charAt(sb.length() - 1) > c && count < k) {
				sb.deleteCharAt(sb.length() - 1);
				++ count;
			}
			if (c != '0' || sb.length() > 0)
				sb.append(c);
		}
		if (sb.length() == 0)
			return "0";
		return sb.substring(0, sb.length() - k + count);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "12222330333444444";
		int k = 3;
		System.out.println(removeKdigits(num, k));
	}

}
