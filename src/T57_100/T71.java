package T57_100;

import java.util.Stack;

public class T71 {

	public String simplifyPath(String path) {
		if (path == null) return null;
		if (path.length() == 0 || path.equals("/")) return "/";
		Stack<String> stack = new Stack<String>();
		String[] paths = path.split("/");
		int len = paths.length;
		for (int i = 0; i < len; ++ i) {
			if (paths[i].equals(".") || paths[i].length() == 0)
				continue;
			if (paths[i].equals("..")) {
				if (!stack.isEmpty()) 
					stack.pop();
			}
			else
				stack.push("/" + paths[i]);
		}
		int size = stack.size();
		if (size == 0) return "/";
		StringBuffer result = new StringBuffer();
		for (int i = 0 ; i < size; ++ i) 
			result.append(stack.get(i));
		return result.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/a/./b/../..//c//";
		T71 t71 = new T71();
		System.out.println(t71.simplifyPath(path));
	}

}
