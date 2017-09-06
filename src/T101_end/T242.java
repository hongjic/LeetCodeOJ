package T101_end;

public class T242 {

	public boolean isAnagram(String s, String t) {
		int[] counts = new int[26],
				countt = new int[26];
		int lens = s.length(), lent = t.length();
		for (int i = 0; i < lens; i ++)
			counts[s.charAt(i) - 97] ++;
		for (int i = 0; i < lent; i ++)
			countt[t.charAt(i) - 97] ++;
		for (int i = 0; i < 26; i ++)
			if (counts[i] != countt[i])
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T242 t242 = new T242();
		System.out.println(t242.isAnagram("anagram", "nagaram"));
	}

}
