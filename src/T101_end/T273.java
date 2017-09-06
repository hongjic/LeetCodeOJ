package T101_end;

import java.util.List;
import java.util.ArrayList;

public class T273 {
	
	private static final String[] word = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	private static final String[] teen = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static final String[] tens = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"}; 
	
	private String buildString(List<String> list) {
		int len = list.size();
		if (len == 0) return "Zero";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i ++)
			if (i == 0)
				sb.append(list.get(i));
			else
				sb.append(' ').append(list.get(i));
		return sb.toString();
	}
	
	private String threeNumber(int num) {
		List<String> list = new ArrayList<String>();
		int a = num / 100,
			b = num / 10 % 10,
			c = num % 10;
		if (a > 0) {
			list.add(word[a]);
			list.add("Hundred");
		}
		if (b == 1) 
			list.add(teen[c]);
		else {
			if (b > 0)
				list.add(tens[b]);
			if (c > 0)
				list.add(word[c]);
		}
		return buildString(list);
	}
	
	public String numberToWords(int num) {
		if (num == 0) return "Zero";
		String billion = threeNumber(num / 1000000000);
		String million = threeNumber(num / 1000000 % 1000);
		String thousand = threeNumber(num / 1000 % 1000);
		String one = threeNumber(num % 1000);
		List<String> list = new ArrayList<String>();
		if (!billion.equals("Zero")) {
			list.add(billion);
			list.add("Billion");
		}
		if (!million.equals("Zero")) {
			list.add(million);
			list.add("Million");
		}
		if (!thousand.equals("Zero")) {
			list.add(thousand);
			list.add("Thousand");
		}
		if (!one.equals("Zero")) 
			list.add(one);
		return buildString(list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T273 t273 = new T273();
		System.out.println(t273.numberToWords(12121212));
	}

}
