package T388;

import java.util.Stack;

public class Solution {

	public int lengthLongestPath(String input) {
		String[] inputList = input.split("\n");
		Stack<String> stack = new Stack<String>();
		int len = 0, maxLen = 0;
		for (int i = 0; i < inputList.length; i ++) {
			String cur = inputList[i];
			int tabs = 0;
			while (tabs < cur.length() && cur.charAt(tabs) == '\t')
				tabs ++;
			while (tabs < stack.size()) 
				len -= stack.pop().length();
			stack.push(cur.substring(tabs));
			len += cur.length() - tabs;
			if (cur.indexOf(".") >= 0)
				maxLen = Math.max(maxLen, len + stack.size() - 1);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2"));
	}

}
