package T304;

public class NumMatrix {

    private int[][] sums;
    private int rows, cols;

    public NumMatrix(int[][] matrix) {
        rows = matrix.length; if (rows == 0) return;
        cols = matrix[0].length;
        sums = new int[rows][cols];
        for (int i = 0; i < rows; i ++)
            for (int j = 0; j < cols; j ++)
                sums[i][j] = sumRegion(i - 1, j) + sumRegion(i, j - 1) - sumRegion(i - 1, j - 1) + matrix[i][j];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(row2, col2) - sumRegion(row2, col1 - 1) - sumRegion(row1 - 1, col2) + sumRegion(row1 - 1, col1 - 1);
    }

    private int sumRegion(int row, int col) {
        if (row < 0 || col < 0) return 0;
        return sums[row][col];
    }
}
