package T12_56;
import java.util.Scanner;


public class T20 {
	
	private static boolean isValid(String s) {
		StringBuffer stack = new StringBuffer("");
		for (int i=0; i<s.length(); i++) {
			char curr = s.charAt(i);
			if (stack.length()==0) stack.append(curr);
			else {
				char last = stack.charAt(stack.length()-1); 
				if (last=='(' && curr==')') stack.deleteCharAt(stack.length()-1);
				else if (last=='[' && curr==']') stack.deleteCharAt(stack.length()-1);
				else if (last=='{' && curr=='}') stack.deleteCharAt(stack.length()-1);
				else stack.append(curr);	
			}
		}
		if (stack.length()==0) 
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println(isValid(input));
	}

}
