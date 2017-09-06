package T119;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		for (int i = 1; i <= rowIndex; i ++) {
			row.add(1);
			for (int j = i - 1; j >= 1; j --)
				row.set(j, row.get(j) + row.get(j - 1));
		}
		return row;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> row = new Solution().getRow(3);
		for (int i = 0; i < row.size(); i ++)
			System.out.print(row.get(i) + ", ");
	}

}
