package T552;

public class Solution {

	public String splitLoopedString(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		int len = strs.length;
		String[] maxStr = new String[len];
		for (int i = 0; i < len; i ++) {
			String rev = new StringBuilder(strs[i]).reverse().toString();
			maxStr[i] = rev.compareTo(strs[i]) > 0 ? rev : strs[i];
		}
		String max = null;
		for (int i = 0; i < strs.length; i ++) {
			String rev = new StringBuilder(strs[i]).reverse().toString();
			StringBuilder sb = new StringBuilder();
			for (String st: new String[]{rev, strs[i]}) {
				for (int j = 0; j < rev.length(); j ++) {
					sb.setLength(0);
					sb.append(st.substring(j));
					for (int k = i + 1; k < maxStr.length; k ++)
						sb.append(maxStr[k]);
					for (int k = 0; k < i; k ++)
						sb.append(maxStr[k]);
					sb.append(st.substring(0, j));
					if (max == null || sb.toString().compareTo(max) > 0)
						max = sb.toString();
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = new Solution().splitLoopedString(new String[]{"abc", "xyz"});
		System.out.println(res);
	}

}
