package T318;

public class Solution {

    private int[] generateCode(String[] words) {
        int size = words.length;
        int[] codes = new int[size];
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < words[i].length(); j ++)
                codes[i] |= 1 << (words[i].charAt(j) - 97);
        }
        return codes;
    }

    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int[] codes = generateCode(words);
        int res = 0;
        for (int i = 0; i < words.length - 1; i ++)
            for (int j = i + 1; j < words.length; j ++)
                if ((codes[i] & codes[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(solution.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(solution.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }
}