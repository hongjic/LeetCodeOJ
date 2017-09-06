package Algorithms.MedianOfTwoSortedArrays;

public class BinarySearchSolution {

	private static double getMedianValue(int[] arr, int left, int right) {
		int length = right-left+1;
		if ((length & 1) == 0) 
			return (double)(arr[left+length/2-1] + arr[left+length/2])/2;
		else 
			return arr[left+length/2];
	}
	
	private static int minOf(int a, int b) {
		if (a<b) return a;
		return b;
	}
	
	private static double getFinalMedian(int c, int[] arr, int left, int right, double median) {
		int len = right-left+1;
		if ((len & 1) == 0) {
			if ((double)c < median) 
				return getFinalMedian(c, arr, left, left+len/2-1, getMedianValue(arr, left, left+len/2-1));
			else 
				return getFinalMedian(c, arr, left+len/2, right, getMedianValue(arr, left+len/2, right));
		}
		else {
			if ((double)c < median) 
				return getFinalMedian(c, arr, left, left+len/2, getMedianValue(arr, left, left+len/2-1));
			else 
				return getFinalMedian(c, arr, left+len/2, right, getMedianValue(arr, left+len/2, right));
		}
		
	}
	
	private static double binarySearch(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2) {
		int len1 = r1-l1+1;
		int len2 = r2-l2+1;
		double median1 = getMedianValue(nums1, l1, r1);
		double median2 = getMedianValue(nums2, l2, r2);
		if (median1 == median2) 
			return median1;
		if (len1 == 1) return getFinalMedian(nums1[l1], nums2, l2, r2, median2);
		if (len2 == 1) return getFinalMedian(nums2[l2], nums1, l1, r1, median1);
		int cut = minOf(len1/2 , len2/2);
		if (median1 < median2) 
			return binarySearch(nums1, l1+cut, r1, nums2, l2, r2-cut);
		else 
			return binarySearch(nums1, l1, r1-cut, nums2, l2+cut, r2);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		return binarySearch(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1);
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[]{1,3,5,7};
		int[] nums2 = new int[]{2,4,6,8,10};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

}
