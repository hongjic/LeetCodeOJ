package Algorithms.RegularExpressionMatching;

public class Solution {

	private static boolean isMatchRecursion(String s, int p1, String p, int p2){
		int lenS = s.length();
		int lenP = p.length();
		if (p1 == lenS && p2 == lenP) //如果都匹配完
			return true;
		if ((p1 < lenS) && (p2 == lenP)) //字符串中还有未匹配的字符
			return false;
		char c = p.charAt(p2);
		if (p2 + 1 < lenP && p.charAt(p2 + 1) == '*') {
			if (isMatchRecursion(s ,p1, p, p2 + 2)) 
				return true;
			int count = 1;
			while (p1 + count - 1 < lenS && (c == '.'  || s.charAt(p1 + count - 1) == c)) { 
				if (isMatchRecursion(s, p1 + count, p, p2 + 2)) 
					return true;
				count ++;
			}
			return false;
		}
		else if (p1 < lenS && (c == '.' || s.charAt(p1) == c)) {
			if (isMatchRecursion(s, p1 + 1, p ,p2 + 1))
				return true;
			return false;
		}
		else {
			return false;
		}
	}
	
	private static boolean isMatch(String s, String p) {
		return isMatchRecursion(s, 0, p, 0);
	}
	
	public static void main(String[] args) {
		String str = "a";
		String regex = ".*..a*";
		System.out.println(isMatch(str, regex));
	}

}
