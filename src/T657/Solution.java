package T657;

public class Solution {

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) return true;
        int v = 0, h = 0;
        for (char c: moves.toCharArray()) {
            if (c == 'U') v ++;
            if (c == 'D') v --;
            if (c == 'L') h --;
            if (c == 'R') h ++;
        }
        if (v == 0 && h == 0) return true;
        return false;
    }

    public static void main(String[] args) {

    }
}
