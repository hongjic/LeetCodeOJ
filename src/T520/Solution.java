package T520;

public class Solution {

    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if (Character.isLowerCase(word.charAt(0))) {
            for (int i = 1; i < len; i++)
                if (!Character.isLowerCase(word.charAt(i))) return false;
            return true;
        }
        if (len == 1) return true;
        if (Character.isLowerCase(word.charAt(1))) {
            for (int i = 2; i < len; i++)
                if (!Character.isLowerCase(word.charAt(i))) return false;
            return true;
        }
        for (int i = 2; i < len; i ++)
            if (!Character.isUpperCase(word.charAt(i))) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("FLag"));
    }
}
