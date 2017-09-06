package T165;

public class Solution {

	public int compareVersion(String version1, String version2) {
		String[] list1 = version1.split("\\.");
		String[] list2 = version2.split("\\.");
		int i = 0, j = 0;
		while (i < list1.length || j < list2.length) {
			int v1 = 0, v2 = 0;
			if (i < list1.length) v1 = Integer.parseInt(list1[i]);
			if (j < list2.length) v2 = Integer.parseInt(list2[j]);
			if (v1 < v2) return -1;
			if (v1 > v2) return 1;
			i ++; j ++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().compareVersion("1", "1.0"));
	}

}
