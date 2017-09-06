package T475;

import java.util.Arrays;

public class Solution {

	public int findRadius(int[] houses, int[] heaters) {
		if (houses == null || houses.length == 0)
			return 0;
		if (heaters == null || heaters.length == 0)
			return 0;
		Arrays.sort(heaters);
		int radius = 0;
		for (int house: houses) {
			if (house > heaters[heaters.length - 1])
				radius = Math.max(radius, house - heaters[heaters.length - 1]);
			else if (house < heaters[0])
				radius = Math.max(radius, heaters[0] - house);
			else {
				int index = binarySearch(heaters, house);
				if (heaters[index] == house) continue;
				radius = Math.max(radius, Math.min(heaters[index] - house, house - heaters[index - 1]));
			}
		}
		return radius;
	}
	
	private int binarySearch(int[] arr, int key) {
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == key) return mid;
			else if (arr[mid] < key) left = mid + 1;
			else right = mid;
		}
		return left;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] houses = new int[] {1,2,3,4,9};
		int[] heaters = new int[] {1,6};
		System.out.println(new Solution().findRadius(houses, heaters));
	}

}
