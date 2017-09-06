package T351;

public class Solution2 {

	private int DFS(boolean[] visited, int[][] skip, int cur, int remain) {
		if (remain < 0) return 0;
		if (remain == 0) return 1;
		visited[cur] = true;
		int sum = 0;
		for (int i = 1; i <= 9; i ++) {
			if (!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]]))
				sum += DFS(visited, skip, i, remain - 1);
		}
		visited[cur] = false;
		return sum;
	}
	
	public int numberOfPatterns(int m, int n) {
		int skip[][] = new int[10][10];
		skip[1][3] = skip[3][1] = 2;
		skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean visited[] = new boolean[10];
        int sum = 0;
        // DFS search each length from m to n
        for(int i = m; i <= n; ++i) {
            sum += DFS(visited, skip, 1, i - 1) * 4;    // 1, 3, 7, 9 are symmetric
            sum += DFS(visited, skip, 2, i - 1) * 4;    // 2, 4, 6, 8 are symmetric
            sum += DFS(visited, skip, 5, i - 1);        // 5
        }
        return sum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().numberOfPatterns(2, 9));
	}

}
