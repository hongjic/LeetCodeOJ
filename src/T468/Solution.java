package T468;

public class Solution {

	private boolean validIPv4(String ip) {
		if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.')
			return false;
		String[] nums = ip.split("\\.");
		if (nums.length != 4) return false;
		try {
			for (int i = 0; i < 4; i ++) {
				if (nums[i].length() == 0) return false;
				if (nums[i].charAt(0) == '0' && nums[i].length() > 1) return false;
				
				char[] arr = nums[i].toCharArray();
				for (char c: arr) 
					if (!(c >= 48 && c <= 57))
						return false;
				
				int num = Integer.valueOf(nums[i]);
				if (num < 0 || num > 255) return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private boolean validIPv6(String IP) {
		if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':')
			return false;
		String[] nums = IP.split(":");
		if (nums.length != 8) return false;
		for (int i = 0; i < 8; i ++) {
			if (nums[i].length() == 0 || nums[i].length() > 4) return false;
			char[] arr = nums[i].toCharArray();
			for (char c: arr) 
				if (!(c >= 48 && c <= 57 || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F'))
					return false;
		}
		return true;
	}
	
	public String validIPAddress(String IP) {
		if (IP == null || IP.length() == 0)
			return "Neither";
		if (IP.indexOf(':') >= 0 && validIPv6(IP))
			return "IPv6";
		if (IP.indexOf('.') >= 0 && validIPv4(IP))
			return "IPv4";
		return "Neither";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.validIPAddress("192.0.0.1"));
	}

}
