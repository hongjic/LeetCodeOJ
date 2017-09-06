package T522;

import java.util.Arrays;

public class Solution {

    private boolean isSubSequence(String str1, String str2) {
        int index1 = 0;
        for (char c: str2.toCharArray()) {
            if (index1 < str1.length() && c == str1.charAt(index1)) {
                index1 ++;
            }
        }
        return index1 == str1.length();
    }

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (str1, str2) -> str2.length() - str1.length());
        boolean found;
        for (int i = 0; i < strs.length; i ++) {
            int j = 0;
            found = true;
            while (j < strs.length && strs[j].length() >= strs[i].length()) {
                if (j != i && isSubSequence(strs[i], strs[j])) {
                    found = false;
                    break;
                }
                j ++;
            }
            if (found) return strs[i].length();
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLUSlength(new String[] {"aba", "cdc", "eae"}));
    }
}
