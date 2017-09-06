package T624;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class Solution {

	public int maxDistance(int[][] arrays) {
		int size = arrays.length;
		List<int[]> first = new ArrayList<int[]>();
		List<int[]> end = new ArrayList<int[]>();
		for (int i = 0; i < size; i ++ ) {
			first.add(new int[]{arrays[i][0], i});
			end.add(new int[]{arrays[i][arrays[i].length - 1], i});
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,2,3}, {4,5}, {1,2,3}};
		System.out.println(new Solution().maxDistance(arr));
	}

}