package T12_56;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class T22 {

	private static void helper(List<String> res, int n, int used, int left, String curr) {
		if (used==n) {
			for (int i=0; i<left; i++)
				curr += ")";
			res.add(curr);
			return;
		}
		if (left>0) 
			helper(res, n, used, left-1, curr+')');
		helper(res, n, used+1, left+1, curr+'(');
	}
	
	private static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		helper(res, n, 0, 0, "");
		return res;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(generateParenthesis(n));
	}

}
