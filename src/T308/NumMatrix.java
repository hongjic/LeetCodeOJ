package T308;

/*
Because the number of calls to update and sumRegion function is distributed evenly,
the time complexity of this two function should not have big difference.
Both O(n)
 */
public class NumMatrix {

    private int[][] matrix;
    private int rows, cols;
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix == null) return;
        this.matrix = matrix;
        rows = matrix.length;
        if (rows == 0) return;
        cols = matrix[0].length;
        sums = new int[rows][cols];
        for (int i = 0; i < rows; i ++)
            for (int j = 0; j < cols; j ++)
                sums[i][j] = (j == 0 ? matrix[i][j] : sums[i][j - 1] + matrix[i][j]);
    }

    public void update(int row, int col, int val) {
        int oldVal = matrix[row][col];
        for (int i = col; i < cols; i ++)
            sums[row][i] += val - oldVal;
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(row2, col2) - sumRegion(row2, col1 - 1) - sumRegion(row1 - 1, col2) + sumRegion(row1 - 1, col1 - 1);
    }

    private int sumRegion(int row, int col) {
        if (row < 0 || col < 0) return 0;
        int sum = 0;
        for (int i = 0; i <= row; i ++)
            sum += sums[i][col];
        return sum;
    }

    public static void main(String[] args){
        int[][] matrix = {{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {4,1,0,1,7}, {1,0,3,0,5}};
        NumMatrix nm = new NumMatrix(matrix);
        System.out.println(nm.sumRegion(2,1,4,3));
        nm.update(3,2,2);
        System.out.println(nm.sumRegion(2,1,4,3));
        NumMatrix nm2 = new NumMatrix(null);
    }
}
