package T12_56;
public class T38 {

	private static String countAndSay(int n) {
		StringBuffer st = new StringBuffer("1");
		if (n==1) return st.toString();
		for (int times=1; times<n; times++) {
			int i=0, start=0, len=st.length();
			while (i<len) {
				start = i;
				while (i<len-1 && st.charAt(i)==st.charAt(i+1))
					i++;
				st.replace(start, i+1, ""+(char)(i-start+49)+st.charAt(start));
				len = st.length();
				i = start+2;
			}
		}
		return st.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(10));
	}

}






//public class Solution {
//    public String countAndSay(int n) {
//        String str = "1";
//        for(int i=0;i<n-1;i++){
//            str = calculate(str);
//        }
//        return str;
//    }
//    public String calculate(String str){
//        int n = str.length();
//        int count = 1;
//        StringBuilder sb = new StringBuilder();
//        for(int j=0;j<n;j++){
//            if((j+1<n)&&str.charAt(j)==str.charAt(j+1)){
//                count++;
//            }else{
//                sb.append(count);
//                sb.append(str.charAt(j));
//                count=1;
//            }
//        }
//        return sb.toString();
//    }
//}