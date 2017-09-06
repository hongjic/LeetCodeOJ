package T101_end;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class T301 {
	
	private String reverse(String s) {
		StringBuffer result = new StringBuffer();
		if (s == null) return null;
		int len = s.length();
		for (int i = len-1; i >= 0; i --) {
			if (s.charAt(i) == '(')
				result.append(')');
			else if (s.charAt(i) == ')')
				result.append('(');
			else result.append(s.charAt(i));
		}
		return result.toString();
	}
	
	private void remove(String s, Set<String> result, boolean reverse) {
		if (s == null) return;
		int len = s.length();
		int count = 0, p = 0, end = -1;
		for (p = 0; p < len; p ++) {
			if (s.charAt(p) == '(')
				count ++;
			if (s.charAt(p) == ')')
				count --;
			if (count < 0) break;
			if (count == 0) end = p;
		}
		// all positive
		if (p == len) {
			if (end + 1 == len) {
				if (!reverse)
					result.add(s);
				else result.add(reverse(s));
			}
			else {
				remove(reverse(s), result, !reverse);
			}
			return;
		}
		for (int i = 0; i <= p; i ++) {
			if (s.charAt(i) == ')' && (i == 0 || s.charAt(i - 1) != ')')) {
				StringBuffer ss = new StringBuffer(s);
				remove(ss.deleteCharAt(i).toString(), result, reverse);
			}
		}
	}

	public List<String> removeInvalidParentheses(String s) {
		Set<String> result = new HashSet<String>();
		remove(s, result, false);
		return new ArrayList<String>(result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T301 t301 = new T301();
		String s = "(((k()((";
		List<String> results = t301.removeInvalidParentheses(s);
		for (int i = 0; i < results.size(); i ++)
			System.out.println(results.get(i));
	}

}
