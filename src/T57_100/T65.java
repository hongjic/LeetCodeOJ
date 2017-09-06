package T57_100;

public class T65 {

	public boolean isNumber(String s) {
		if(s == null)
            return false;
        s = s.trim();
        if(s.length() == 0)
            return false;
        char [] isNum = s.toCharArray();
        boolean isDot = false;
        boolean isDigit = false;
        boolean isE = false;
        for(int index = 0; index < isNum.length; index++){
            char ele = isNum[index];
            if(ele == '+' || ele == '-'){
                if(index != 0 && isNum[index - 1] != 'e')
                    return false;
                if(index == isNum.length - 1)
                    return false;
                continue;
            }
            
            if(ele == '.'){
                if(isE || isDot || isNum.length == 1)
                    return false;
                if(index == isNum.length - 1 && !isDigit)
                    return false;
                isDot = true;
                continue;
            }
            
            if(ele == 'e'){
                if(isE || !isDigit)
                    return false;
                if(index == isNum.length - 1)
                    return false;
                isE = true;
                continue;
            }
            
            if(ele - 48 > 9 || ele - 48 < 0)
                return false;
            else
                isDigit = true;
            
        }
        
        return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T65 t65 = new T65();
		String s = "959440.94f";
		System.out.println(t65.isNumber(s));
		
	}

}




//public class Solution {
//    public boolean isNumber(String s) {
//    boolean eFound = false;
//    boolean eValid = false;
//    boolean periodValid = true;
//    boolean pmValid = true;
//    boolean numberEncountered = false;
//    s = s.trim();
//    for(char c : s.toCharArray()) {
//        if(pmValid) {
//            pmValid = false;
//            if(c == '+' || c == '-') continue;
//        }
//        if(eValid && !eFound && c == 'e') {
//            eValid = false;
//            eFound = true;
//            periodValid = false;
//            pmValid = true;
//            numberEncountered = false;
//            continue;
//        }
//        if(periodValid && c == '.') {
//            periodValid = false;
//            continue;
//        }
//        if(c < '0' || c > '9') {
//            return false;
//        }
//        eValid = !eFound;
//        numberEncountered = true;
//    }
//    return numberEncountered;
//}
//}