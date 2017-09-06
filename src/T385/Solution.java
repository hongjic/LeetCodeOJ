package T385;

//import java.util.Stack;

// No implementation of NestedInteger.
public class Solution {

//	public NestedInteger deserialize(String s) {
//        int len = s.length();
//        Stack<NestedInteger> stack = new Stack<NestedInteger>();
//        NestedInteger res = null;
//        int i = 0;
//        while ( i < len ) {
//            if (s.charAt(i) == '[') stack.push(new NestedInteger());
//            if (s.charAt(i) == ']') {
//                NestedInteger top = stack.pop();
//                if (!stack.isEmpty()) stack.peek().add(top);
//                else res = top;
//            }
//            if (s.charAt(i) == '-' || s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//                int num = 0;
//                boolean negative = false;
//                if (s.charAt(i) == '-') { 
//                    i ++;
//                    negative = true;
//                }
//                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9')
//                    num = num * 10 + s.charAt(i ++) - 48;
//                if (negative) num = 0 - num;
//                if (!stack.isEmpty()) stack.peek().add(new NestedInteger(num));
//                else res = new NestedInteger(num);
//                i --;
//            }
//            i ++;
//        }
//        return res;
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
