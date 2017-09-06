package T498;

import java.util.Iterator;

public class Solution {

    private class DiagonalOrder implements Iterator<int[]> {

        private static final boolean RIGHTUP = true;
        private static final boolean LEFTDOWN = false;

        private int[] pos;
        private boolean direction;
        private int rows, cols;

        public DiagonalOrder(int m, int n) {
            pos = new int[] {0, 0};
            direction = RIGHTUP;
            rows = m; cols = n;
        }

        private boolean isValid(int[] pos) {
            if (pos[0] >= 0 && pos[0] < rows && pos[1] >= 0 && pos[1] < cols)
                return true;
            return false;
        }

        private void turnDirection(int[] p) {
            if (p[1] >= cols) {
                p[0] = pos[0] + 1; p[1] = pos[1];
            }
            else if (p[0] >= rows) {
                p[0] = pos[0]; p[1] = pos[1] + 1;
            }
            else if (p[0] < 0) {
                p[0] = pos[0]; p[1] = pos[1] + 1;
            }
            else if (p[1] < 0) {
                p[0] = pos[0] + 1; p[1] = pos[1];
            }
            if (direction == RIGHTUP) direction = LEFTDOWN;
            else direction = RIGHTUP;
        }

        @Override
        public int[] next() {
            int[] curPos = pos;
            int[] newPos = new int[2];
            if (direction == RIGHTUP) {
                newPos[0] = pos[0] - 1;
                newPos[1] = pos[1] + 1;
            }
            else {
                newPos[0] = pos[0] + 1;
                newPos[1] = pos[1] - 1;
            }
            if (isValid(newPos)) pos = newPos;
            else {
                turnDirection(newPos);
                pos = newPos;
            }
            return curPos;
        }

        @Override
        public boolean hasNext() {
            return isValid(pos);
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return new int[0];
        int rows = matrix.length, cols = matrix[0].length;
        DiagonalOrder order = new DiagonalOrder(rows, cols);
        int[] res = new int[rows * cols];
        int index = 0;

        while (order.hasNext()) {
            int[] curPos = order.next();
            res[index ++] = matrix[curPos[0]][curPos[1]];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18}};
        int[] res = new Solution().findDiagonalOrder(matrix);
        for (int r: res)
            System.out.print(r + ", ");

    }
}
