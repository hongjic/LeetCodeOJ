package Contest3;

public class T394 {

	private static String decodeString(String s) {
		if (s.equals("")) 
			return "";
		StringBuffer res = new StringBuffer();
		if (s.charAt(0)-48>=0 && s.charAt(0)-48<=9) {
			int i = 0, times = 0;
			while (s.charAt(i)-48>=0 && s.charAt(i)-48<=9) {
				times = times*10+s.charAt(i)-48;
				i++;
			}
			//get times
			i++;
			int count_p=1;
			StringBuffer tmp = new StringBuffer();
			while (count_p>0) {
				tmp.append(s.charAt(i));
				if (s.charAt(i) == '[') 
					count_p++;
				else if (s.charAt(i) == ']')
					count_p--;
				i++;
			}
			tmp.deleteCharAt(tmp.length()-1); //删掉最后一个］
			String tmp_after = decodeString(tmp.toString());
			for (int t=0; t<times; t++) 
				res.append(tmp_after);
			res.append(decodeString(s.substring(i)));
		}
		else 
			res.append(s.charAt(0)).append(decodeString(s.substring(1)));
		return res.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("10[leetcode]"));
	}

}
