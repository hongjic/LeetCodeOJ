package T406;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	private static class HComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] a, int[] b) {
			if (a[0] != b[0]) return a[0] - b[0];
			return a[1] - b[1];
		}
	}
	
	public int[][] reconstructQueue(int[][] people) {
		int num = people.length;
		if (num <= 1) return people;
		Arrays.sort(people, new HComparator());
		int i = 0;
		List<Integer> p = new ArrayList<Integer>();
		int[][] result = new int[num][2];
		Arrays.fill(result, null);
		while (i < num) {
			int h = people[i][0];
			p.clear();
			p.add(people[i][1]);
			while (i + 1 < num && people[i + 1][0] == people[i][0]) {
				i ++;
				p.add(people[i][1]);
			}
			
			int j = 0, k = 0, count = 0;
			while (k < num && j < p.size()) {
				if (result[k] == null) {
					if (count == p.get(j)) {
						result[k] = new int[] {h, p.get(j)};
						j++;
					}
					count ++;
				}
				k ++;
			}
			i ++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] people = new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] people = new int[][] {{9,0}, {7,0}, {1,9}, {3,0}, {2,7}, {5,3}, {6,0}, {3,4}, {6,2}, {5,2}};
		int[][] result = new Solution().reconstructQueue(people);
		for (int i = 0; i < result.length; i ++) {
			for (int j = 0; j < result[i].length; j ++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}
	}

}
