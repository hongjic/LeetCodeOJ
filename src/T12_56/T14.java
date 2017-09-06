package T12_56;

public class T14 {

	private static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		for (int i=1; i<strs.length; i++) {
			int end = strs[0].length()-1;
			while (end>=0 && !strs[i].startsWith(strs[0].substring(0, end+1)))
				end--;
			if (end<0) return "";
			strs[0] = strs[0].substring(0, end+1);
		}
		return strs[0];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[]{"cc", "ccc", "ccb"};
		System.out.println(longestCommonPrefix(strs));
	}

}