package T218;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

	public List<int[]> getSkyline(int[][] buildings) {
		Arrays.sort(buildings, new Comparator<int[]>(){
			@Override
			public int compare(int[] b1, int[] b2) {
				return b1[0] - b2[0];
			}
		});
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>(){
			@Override
			public int compare(int[] b1, int[] b2) {
				return b2[2] - b1[2];
			}
		});
		List<int[]> res = new ArrayList<int[]>();
		heap.offer(new int[]{0, Integer.MAX_VALUE, 0});
		int pre = -1;
		for (int[] building: buildings) {
			// poll
			while (building[0] > heap.peek()[1]) {
				int[] out = heap.poll();
				while (heap.size() > 1 && heap.peek()[1] <= out[1])
					heap.poll();
				if (heap.peek()[2] != out[2]) res.add(new int[]{out[1], heap.peek()[2]});
			}
			// check height
			if (building[2] > heap.peek()[2]) {
				if (building[0] == pre) res.get(res.size() - 1)[1] = building[2];
				else {
					res.add(new int[]{building[0], building[2]});
					pre = building[0];
				}
			}
			heap.offer(building);
		}
		// poll the remain
		while (heap.size() > 1) {
			int[] out = heap.poll();
			while (heap.size() > 1 && heap.peek()[1] <= out[1])
				heap.poll();
			if (heap.peek()[2] != out[2]) res.add(new int[]{out[1], heap.peek()[2]});
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] buildings = new int[][]{
//				{0,5,7}, {5,10,7}, {5,10,12}, {10,15,7}, {15,20,7}, {15,20,12}, {20,25,7}
//				{1,1,3}, {1,2,3}, {1,3,3}, {2,4,2}
//				{0,2147483647,2147483647}
				{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}
		};
		List<int[]> res = new Solution().getSkyline(buildings);
		for (int i = 0; i < res.size(); i ++)
			System.out.println(res.get(i)[0] + ", " + res.get(i)[1]);
	}
}
