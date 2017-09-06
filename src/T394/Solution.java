package T394;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Integer> times = new Stack<Integer>();
        Stack<Integer> leftIndex = new Stack<Integer>();
        StringBuffer result = new StringBuffer();
        int len = s.length();
        int i = 0;
        while (i < len) {
            if (s.charAt(i) - 48 >= 0 && s.charAt(i) - 48 <= 9) {
                int num = 0;
                while (s.charAt(i) - 48 >= 0 && s.charAt(i) - 48 <= 9) {
                    num = num * 10 + s.charAt(i) - 48;
                    i ++;
                }
                times.push(num);
                continue;
            }
            if (s.charAt(i) == '[') 
                leftIndex.push(result.length());
            else if (s.charAt(i) != ']') {
                result.append(s.charAt(i));
            }
            else { // s.charAt(i) is a ']'
                int num = times.pop();
                int left = leftIndex.pop();
                int right = result.length() - 1;
                for (int t = 0; t < num - 1; t ++)
                    for (int k = left; k <= right; k ++)
                        result.append(result.charAt(k));
            }
            i ++;
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.decodeString("2[a3[bc]]"));
    }
}