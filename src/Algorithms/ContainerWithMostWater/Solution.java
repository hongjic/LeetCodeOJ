package Algorithms.ContainerWithMostWater;

public class Solution {

	private void sort(int[] h, int[] order, int left, int right) {
		if (left >= right) return;
		int i = left;
		int j = right;
		int mid = (i+j)/2;
		int key = h[mid], keyo = order[mid];
		while (i < j) {
			while (i < j && key <= h[j]) j--;
			h[i] = h[j]; 
			order[i] = order[j];
			while (i < j && key >= h[i]) i++;
			h[j] = h[i];
			order[j] = order[i];
		}
		h[i] = key;
		order[i] = keyo;
		sort(h, order, left, i-1);
		sort(h, order, i+1, right);
	}	
	
	public int maxArea(int[] height) {
		int len = height.length;
		int[] order = new int[len];
		for (int i = 0; i < len; i++) 
			order[i] = i;
		int[] h = height.clone();
		sort(h, order, 0, len-1);
		int max = 0, left = 0, right = len-1;
		for (int i = 0; i < len; i++) {
			int index = order[i];
			int hh = height[index];
			while (height[left] < 0) left++;
			while (height[right] < 0) right--;	
			int ww = index-left;
			if (right-index > ww) 
				ww = right-index;
			int area = ww * hh;
			if (area > max) 
				max = area;
			height[index] = -1;
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(0);
	}
}