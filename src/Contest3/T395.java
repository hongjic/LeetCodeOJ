package Contest3;

import java.util.ArrayList;
import java.util.List;


public class T395 {

	private static boolean check(List<Integer> a, List<Integer> b, int k) {
		for (int i=0; i<26; i++) {
			int d = b.get(i)-a.get(i);
			if ( d!=0 && d<k )
				return false;
		}
		return true;
	}
	
	private static int longestSubstring(String s, int k) {
		int len = s.length();
		if (len==0) return 0;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> sub_list = new ArrayList<Integer>();
		for (int i=0; i<26; i++)
			sub_list.add(0);
		sub_list.set(s.charAt(0)-97, 1);
		list.add(sub_list);
		for (int i=1; i<len; i++) {
			sub_list = new ArrayList<Integer>();
			sub_list.addAll(list.get(i-1));
			sub_list.set(s.charAt(i)-97, sub_list.get(s.charAt(i)-97)+1);
			list.add(sub_list);
		}
		for (int length=len; length>=k; length--){
			boolean flag = true;
			for (int i=0; i<26; i++)
				if (list.get(length-1).get(i)!=0 && list.get(length-1).get(i)<k) {
					flag = false;
					break;
				}
			if (flag) return length;
			for (int start=1; start<= len-length; start++) {
				int end = start+length-1;
				if (check(list.get(start-1), list.get(end), k))
					return length;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(longestSubstring("ababbc", 2));
		System.out.println(longestSubstring("hadccccccddddcccccddddddccccccccdddddddeeffgglhkj",7));
		
	}

}
