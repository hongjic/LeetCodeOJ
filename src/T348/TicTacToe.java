package T348;

public class TicTacToe {

    private int N;
    private int[][] hCount, vCount, dCount;

    public TicTacToe(int n) {
        N = n;
        hCount = new int[n][2];
        vCount = new int[n][2];
        dCount = new int[2][2];
    }

    public int move(int row, int col, int player) {
        hCount[row][player - 1] ++;
        vCount[col][player - 1] ++;
        if (row == col) dCount[0][player - 1] ++;
        if (row + col + 1 == N) dCount[1][player - 1] ++;
        if (hCount[row][player - 1] == N || vCount[col][player - 1] == N || dCount[0][player - 1] == N || dCount[1][player - 1] == N)
            return player;
        return 0;
    }

    public static void main(String[] args) {
        TicTacToe tic = new TicTacToe(3);
        System.out.println(tic.move(0, 0, 1));
        System.out.println(tic.move(0, 2, 2));
        System.out.println(tic.move(2, 2, 1));
        System.out.println(tic.move(1, 1, 2));
        System.out.println(tic.move(2, 0, 1));
        System.out.println(tic.move(1, 0, 2));
        System.out.println(tic.move(2, 1, 1));

    }
}
