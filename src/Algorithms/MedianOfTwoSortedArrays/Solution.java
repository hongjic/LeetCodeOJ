package Algorithms.MedianOfTwoSortedArrays;

public class Solution {
	private static class MultiArray {
		private int[] arr1, arr2;
		
		MultiArray(int[] _arr1, int[] _arr2) {
			this.arr1 = _arr1;
			this.arr2 = _arr2;
		}
		
		public int at(int index) {
			if (index < arr1.length) 
				return arr1[index];
			return arr2[index-arr1.length];
		}
		
		public int set(int index, int value) {
			int oldValue;
			if (index < arr1.length) {
				oldValue = arr1[index];
				arr1[index] = value;
			}
			else {
				oldValue = arr2[index-arr1.length];
				arr2[index-arr1.length] = value;
			}
			return oldValue;
		}
		
		public int length() {
			return arr1.length + arr2.length;
		}
		
		public void sort(){
			quicksort(this, 0, length()-1);
		}
		
		private void quicksort(MultiArray arr, int left, int right) {
			if (left >= right) return;
			int i = left;
			int j = right;
			int key = arr.at(left);
			while (i<j) {
				while (i<j && key<=arr.at(j)) j--;
				arr.set(i, arr.at(j));
				while (i<j && key>=arr.at(i)) i++;
				arr.set(j, arr.at(i));
			}
			arr.set(i, key);
			quicksort(arr, left, i-1);
			quicksort(arr, i+1, right);
		}
		
	}

	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		MultiArray arr = new MultiArray(nums1, nums2);
		arr.sort();
		int len = arr.length();
		if ((len & 1) == 0) 
			return (double)(arr.at(len/2-1) + arr.at(len/2))/2;
		else 
			return arr.at(len/2);
		
    }
	
	public static void main(String[] args) {
		int[] nums1 = new int[]{};
		int[] nums2 = new int[]{2};
		System.out.println(findMedianSortedArrays(nums1, nums2));

	}

}
