package T12_56;

import java.util.Scanner;

public class T12 {

	private static String intToRoman(int num) {
		String res = "";
		String c[] = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
		int n[] = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
		int i = 12;
		while (num > 0 && i>=0) {
			if (num >= n[i]){
				res += c[i];
				num -= n[i];
			} else {
				i--;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(intToRoman(num));
	}

}
