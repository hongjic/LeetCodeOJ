package T678;

public class Solution {

    public boolean checkValidString(String s) {
        return checkValidString(s, 0, 0);
    }

    private boolean checkValidString(String s, int leftCount, int index) {
        int i = index;
        while (i < s.length() && s.charAt(i) != '*') {
            if (s.charAt(i) == '(') leftCount ++;
            else {
                leftCount --;
                if (leftCount < 0) return false;
            }
            i ++;
        }

        if (i == s.length()) {  //reach end
            return leftCount == 0;
        }

        return checkValidString(s, leftCount + 1, i + 1) ||
                checkValidString(s, leftCount - 1, i + 1) ||
                checkValidString(s, leftCount, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString(""));
    }
}
