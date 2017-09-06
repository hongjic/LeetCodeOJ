package T12_56;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class T17 {
	private static char[][] trans = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l',},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
	
	private static void search(List<String> res, int index, String digits, String letters) {
		if (index == digits.length()) {
			if (letters!="")
				res.add(letters);
			return;
		}
		int digit = digits.charAt(index)-48;
		int len = trans[digit].length;
		if (len<2) {
			search(res, index+1, digits, letters);
			return;
		}
		for (int i = 0; i<trans[digit].length; i++) {
		    search(res, index+1, digits, letters+trans[digit][i]);
		}
	}
	
	private static List<String> letterCombinations(String digits) {
		if (digits.contains("0") || digits.contains("1") || digits.length() == 0) {
    		return new ArrayList<String>();
    	}
		List<String> res = new ArrayList<String>();
		search(res, 0, digits, "");
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		List<String> res = letterCombinations(input);
		for (int i=0; i<res.size(); i++)
			System.out.print(res.get(i)+" ");
	}

}
