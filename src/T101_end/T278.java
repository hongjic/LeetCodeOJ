package T101_end;

public class T278 {
	
	public class VersionControl {
		public boolean isBadVersion(int version) {
			return false;
		}
	}

	public class Solution extends VersionControl {
	    
	    private int helper(int left, int right) {
	        if (left == right)
	            return left;
	        int mid = left + (right - left) / 2;
	        if (isBadVersion(mid))
	            return helper(left, mid);
	        return helper(mid + 1, right);
	    }
	    
	    public int firstBadVersion(int n) {
	        return helper(1, n);
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
