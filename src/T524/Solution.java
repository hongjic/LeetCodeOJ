package T524;

import java.util.*;

public class Solution {

    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;

            if (i == dictWord.length() && dictWord.length() >= longest.length())
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                    longest = dictWord;
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        System.out.println(s.findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
        System.out.println(s.findLongestWord("abpcplea", Arrays.asList("aaaa", "bbbbb", "cccc")));
    }
}
