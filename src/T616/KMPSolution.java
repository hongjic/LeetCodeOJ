package T616;

/*
This solution uses KMP algorithm to match strings
Time complexity is O(k(m + n))
k: number of strings in dict
m: length of original string
n: length of strings in dict
 */

import java.util.Arrays;

public class KMPSolution {

    private int[] getNextForKMP(String pattern) {
        int[] next = new int[pattern.length()];
        for (int i = 1; i < pattern.length(); i ++) {
            int len = next[i - 1];
            while (len > 0 && pattern.charAt(i) != pattern.charAt(len))
                len = next[len - 1];
            if (pattern.charAt(i) == pattern.charAt(len))
                next[i] = len + 1;
        }
        return next;
    }

    public String addBoldTag(String s, String[] dict) {
        int size = s.length();
        boolean[] bold = new boolean[size];

        for (String str: dict) {
            // find all index where `str` locate in `s`
            int[] next = getNextForKMP(str);
            int idx = 0, last = -1;
            for (int i = 0; i < s.length(); i ++) {
                if (str.charAt(idx) == s.charAt(i))
                    idx ++;
                else {
                    while (idx > 0 && (s.charAt(i) != str.charAt(idx)))
                        idx = next[idx - 1];
                    if (str.charAt(idx) == s.charAt(i))
                        idx ++;
                }
                if (idx == next.length) {
                    int start = Math.max(last + 1, i - next.length + 1);
                    Arrays.fill(bold, start, i + 1, true);
                    last = i;
                    idx = next[idx - 1];
                }
            }
        }


        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i < size) {
            if (!bold[i])
                builder.append(s.charAt(i ++));
            else {
                builder.append("<b>");
                while (i < size && bold[i]) {
                    builder.append(s.charAt(i ++));
                }
                builder.append("</b>");
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new KMPSolution().addBoldTag("aaabbcc", new String[] {"aaa", "aab", "bc"}));
        System.out.println(new KMPSolution().addBoldTag("abcxyz123", new String[] {"abc", "123"}));
    }
}
