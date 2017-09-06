package T12_56;
public class T32 {

	private static int longestValidParentheses(String s) {
		int len_s = s.length();
		if (len_s == 0) return 0;
		int[] f = new int[len_s];
		//f[n] means the longestValidParentheses substring ending at n 
		f[0] = 0;
		int max = 0;
		for (int i=0;i<len_s-1;i++) {
			if (s.charAt(i+1)=='(') {
				// if the end of substring is '(', it cant be a valid string
				f[i+1] = 0;
				continue;
			}
			// s.charAt(i+1) == ')'
			// you get ')' at i+1 so check for the '(' on the left.
			if (i-f[i]>=0 && s.charAt(i-f[i])=='(') {
				f[i+1] = 2 + f[i]; 
				//2 means the '(' at i-f[i] and ')' at i+1,
				if (i-f[i]-1>=0)
					f[i+1] += f[i-f[i]-1];
			}
			if (f[i+1]>max) max = f[i+1];
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses("((()(()))((()))))))))((()))"));
	}

}





//public class Solution {
//    public int longestValidParentheses(String s) {
//    int n = s.length();
//    if(s.length() < 2) return 0;
//    LinkedList<Integer> list = new LinkedList<>();
//    int left = 0;
//    for(char c : s.toCharArray())
//    {
//        if(c == '(')
//        {
//            list.add(0);
//            left++;
//        }
//        else
//        {
//            if(left > 0)
//            {
//                list.removeLastOccurrence(0);
//                list.add(2);
//                left--;
//            }
//            else
//            {
//                list.add(1);
//            }
//        }
//    }
//    int two = 0;
//    int max = 0;
//    boolean flag = true;
//    for(int num : list)
//    {
//        if(num == 2)
//        {
//        two++;
//        if(!flag) flag = true;
//        }
//        else
//        {
//            if(flag)
//            {
//            max = Math.max(two, max);
//            two = 0;
//            flag = false;
//            }
//        }
//    }
//    max = Math.max(two, max);
//    return 2 * max;
//}
//}