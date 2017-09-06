package T551;

public class Solution {

	public boolean checkRecord(String s) {
		if (s == null || s.length() == 0) return true;
		int A = 0, CL = 0;
		for (int i = 0; i < s.length(); i ++) {
			if (s.charAt(i) == 'L') {
				CL ++;
				if (CL > 2) return false;
			}
			else {
				CL = 0;
				if (s.charAt(i) == 'A') {
					A++;
					if (A > 1) return false;
				}
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = new Solution().checkRecord("LLL");
		System.out.println(res);
	}

}
