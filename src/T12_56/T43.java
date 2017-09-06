package T12_56;

public class T43 {

	public String multiply(String num1, String num2) {
		if (num1==null || num2==null || num1.length()==0 || num2.length()==0)
			return "";
		int len1 = num1.length(),
			len2 = num2.length();
		int[] ans = new int[len1+len2+1];
		int plus, max=0, j;
		for (int i=len2-1; i>=0; i--) {
			plus = 0; 
			j = len1-1;
			while (j>=0) {
				ans[len2-i+len1-j-2] += (num2.charAt(i)-48)*(num1.charAt(j)-48) + plus;
				plus = ans[len2-i+len1-j-2]/10;
				ans[len2-i+len1-j-2] -= plus*10;
				j--;
			}
			if (plus>0) {
				ans[len2-i+len1-1] += plus;
				max = len2-i+len1-1;
			}
		}
		StringBuffer sb = new StringBuffer();
		int i = Math.max(max, len2+len1-2);
		while (i>=0 && ans[i]==0) i--;
		if (i<0) i = 0;
		while (i>=0) {
			sb.append((char)(ans[i]+48));
			i--;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T43 t43 = new T43();
		System.out.println(t43.multiply("98765", "00"));
	}

}









//public class Solution {
//    public String multiply(String num1, String num2) {
//        char[] n1 = toI(num1.toCharArray());
//        char[] n2 = toI(num2.toCharArray());
//        char[] prod = new char[n1.length+n2.length];
//        int carry = 0;
//        int xp = 1;
//
//        Arrays.fill(prod, (char)0);
//        for ( int x1=n1.length-1; x1>=0; x1-- ) {
//            if ( n1[x1] > 0 ) {
//                for ( int x2=n2.length-1; x2>=0; x2-- ) {
//                    xp = x1 + x2 + 1;
//                    int val = (int)prod[xp];
//                    val = val + carry + (n1[x1] * n2[x2]);
//                    prod[xp] = (char)(val % 10);
//                    carry = val / 10;
//                }
//
//                if ( carry != 0 ) {
//                    prod[xp-1] = (char)carry;
//                    carry = 0;
//                }
//            }
//        }
//
//        String product = String.valueOf(toC(prod));
//        while ( product.charAt(0) == '0' && product.length() > 1 ) {
//            product = product.substring(1);
//        }
//
//        return product;
//    }
//
//    char[] toI(char[] num) {
//        for ( int n=0; n<num.length; n++ ) {
//            num[n] -= '0';
//        }
//
//        return num;
//    }
//
//    char[] toC(char[] num) {
//        for ( int n=0; n<num.length; n++ ) {
//            num[n] += '0';
//        }
//
//        return num;
//    }
//}