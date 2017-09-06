package T583;

/*
This problem is equal to finding the longest same subsequence in both string.
Classic DP
 */

public class Solution {

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0)
            return Math.max(word1.length(), word2.length());
        int[][] f = new int[word1.length()][word2.length()];

        // initialization
        boolean found = false;
        for (int i = 0; i < word2.length(); i ++)
            if (found || word1.charAt(0) == word2.charAt(i)) {
                f[0][i] = 1; found = true;
            }
        found = false;
        for (int i = 0; i < word1.length(); i ++)
            if (found || word1.charAt(i) == word2.charAt(0)) {
                f[i][0] = 1; found = true;
            }

        // dp
        for (int i = 1; i < word1.length(); i ++)
            for (int j = 1; j < word2.length(); j ++)
                if (word1.charAt(i) == word2.charAt(j)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
                else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1]);
                }

        return word1.length() + word2.length() - f[word1.length() - 1][word2.length() - 1] * 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("a", "ab"));
    }
}
