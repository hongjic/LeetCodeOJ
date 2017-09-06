package T12_56;
import java.util.List;


public class T44 {

	private boolean match(char p, char s) {
		if (p=='?') return true;
		else if (p==s) return true;
		else return false;
	}
	
	public boolean isMatch(String s, String p) {
		int len_s = s.length(),
			len_p = p.length();
		if (len_s==0 && len_p==0) return true;
		if (len_p==0) return false;
		boolean[][] matches = new boolean[len_p+1][len_s+1];
		//matches[x][y]=true means p[0..x-1] match with s[0..y-1]
		matches[0][0] = true;
		int min, max, pre_min=0, pre_max=len_s-1;
		for (int i=1; i<len_p+1; i++) {
			min = len_s+1; max = -1;
			if (p.charAt(i-1)!='*') {
				boolean flag = false;
				//set up min, max two narrow the range for pointer j. for time improve, but results in none.
				// can just use for (int j=0; j<len_s; j++)
				for (int j=pre_min; j<=pre_max; j++)
					if (matches[i-1][j] && j<len_s && match(p.charAt(i-1), s.charAt(j))) {
						matches[i][j+1] = true;
						if (j+1<min) min = j+1;
						if (j+1>max) max = j+1;
						flag = true;
					}
				if (!flag) return false;
			}
			else {
				int j=0;
				while (!matches[i-1][j]) j++;
				min = j;max = len_s;
				while (j<len_s+1) {
					matches[i][j] = true;
					j++;
				}
			}
			pre_min = min;pre_max = max;
		}
		return matches[len_p][len_s];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T44 t44 = new T44();
		System.out.println(t44.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
	}

}


////here is another amazing solution, seems to be the fastest.
//boolean isMatch(String str, String pattern) {
//    int s = 0, p = 0, match = 0, starIdx = -1;            
//    while (s < str.length()){
//        // advancing both pointers
//        if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
//            s++;
//            p++;
//        }
//        // * found, only advancing pattern pointer
//        else if (p < pattern.length() && pattern.charAt(p) == '*'){
//            starIdx = p;
//            match = s;
//            p++;
//        }
//       // last pattern pointer was *, advancing string pointer
//        else if (starIdx != -1){
//            p = starIdx + 1;
//            match++;
//            s = match;
//        }
//       //current pattern pointer is not star, last patter pointer was not *
//      //characters do not match
//        else return false;
//    }
//    
//    //check for remaining characters in pattern
//    while (p < pattern.length() && pattern.charAt(p) == '*')
//        p++;
//    
//    return p == pattern.length();
//}