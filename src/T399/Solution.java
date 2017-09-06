package T399;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution {

	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queried) {
		int num = equations.length;
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> vars = new ArrayList<String>();
		for (int i = 0; i < num; i ++)
			for (int j = 0; j < 2; j ++)
				if (!map.containsKey(equations[i][j])) {
					vars.add(equations[i][j]);
					map.put(equations[i][j], vars.size() - 1);
				}
		
		double[][] equas = new double[vars.size()][vars.size()];
		for (int i = 0; i < vars.size(); i ++) {
			Arrays.fill(equas[i], -1);
			equas[i][i] = 1;
		}
		
		// read equations one by one and update connections
		for (int i = 0; i < num; i ++) {
			int ii = map.get(equations[i][0]);
			int jj = map.get(equations[i][1]);
			equas[ii][jj] = values[i];
			update(ii, jj, vars, equas);
			equas[jj][ii] = 1.0 / values[i];
			update(jj, ii, vars,equas);
		} 
		
		// output
		double[] result = new double[queried.length];
		for (int p = 0; p < queried.length; p ++)
			if (!map.containsKey(queried[p][0]) || !map.containsKey(queried[p][1]))
				result[p] = -1;
			else 
				result[p] = equas[map.get(queried[p][0])][map.get(queried[p][1])];
		return result;
	}
	
	// connect y to x's friends
	private void update(int x, int y, List<String> vars, double[][] equas) {
		int num = vars.size();
		for (int i = 0; i < num; i ++)
			if (i != x && i != y && equas[i][x] != -1 && equas[i][y] == -1) {
				equas[i][y] = equas[i][x] * equas[x][y];
				update(i, y, vars, equas);
				equas[y][i] = 1.0 / equas[i][y];
				update(y, i, vars, equas);
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] equations = new String[][]{{"a", "b"}, {"e", "f"}, {"b", "e"}};
		double[] values = new double[] {3.4, 1.4, 2.3};
		String[][] queried = new String[][]{{"b", "a"}, {"a", "f"}, {"f", "f"}, {"e", "e"}, {"c", "c"}, {"f","e"}};
		double[] result = new Solution().calcEquation(equations, values, queried);
		for (int i = 0; i < result.length; i ++)
			System.out.print(result[i] + " ");
	}

}
