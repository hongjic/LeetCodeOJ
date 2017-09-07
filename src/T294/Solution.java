package T294;

import java.util.*;

public class Solution {

    private Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        if (map.containsKey(s)) return map.get(s);
        int count = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] == '+') {
                count ++;
                if (count >= 2) {
                    arr[i] = '-'; arr[i - 1] = '-';
                    if (!canWin(String.valueOf(arr))) {
                        map.put(s, true);
                        return true;
                    }
                    arr[i] = '+'; arr[i - 1] = '+';
                }
            }
            else count = 0;
        }
        map.put(s, false);     
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canWin("++++"));
    }
}
