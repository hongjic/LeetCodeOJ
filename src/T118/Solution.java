package T118;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> t = new ArrayList<List<Integer>>();
		if (numRows == 0) return t;
		List<Integer> row = Arrays.asList(1);
		t.add(row);
		for (int i = 1; i < numRows; i ++) {
			row = new ArrayList<Integer>();
			row.add(1);
			for (int j = 0; j < t.get(i - 1).size() - 1; j ++)
				row.add(t.get(i - 1).get(j) + t.get(i - 1).get(j + 1));
			row.add(1);
			t.add(row);
		}
		return t;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> t = new Solution().generate(0);
		for (int i = 0; i < t.size(); i ++) {
			for (int j = 0; j < t.get(i).size(); j ++)
				System.out.print(t.get(i).get(j));
			System.out.println();
		}
	}

}
