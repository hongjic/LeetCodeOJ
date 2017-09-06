package T415;

public class Solution {

    private int getInt(String num, int index) {
        if (index >= 0)
            return num.charAt(index) - 48;
        return 0;
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
            return null;
        int len1 = num1.length(), len2 = num2.length();
        int len = Math.max(len1, len2) + 1;
        int[] res = new int[len];
        int t = 0;

        for (int i = 0, index = len - 1; i < len; i ++, index --) {
            res[index] = getInt(num1, len1 - 1 - i) + getInt(num2, len2 - 1- i) + t;
            t = res[index] / 10;
            res[index] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i ++)
            if (i == 0 && res[i] == 0) continue;
            else sb.append(res[i]);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("99434", "987"));
    }
}
