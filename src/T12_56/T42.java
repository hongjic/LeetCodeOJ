package T12_56;
public class T42 {

	private int biggest(int[] height, int s, int t, boolean flag){
		if (s>t) return -1;
		int max = height[s], max_index = s;
		for (int i=s+1; i<=t; i++)
			if ((flag && height[i]>max) || (!flag && height[i]>=max)) {
				max = height[i];
				max_index = i;
			}
		return max_index;
	}
	
	private int helper(int[] height, int s, int t) {
		if (s>=t) return 0;
		int max_index = biggest(height, s, t, true);
		int left_index = biggest(height, s, max_index-1, true);
		int right_index = biggest(height, max_index+1, t, false);
		int sum = 0;
		if (left_index!=-1) {
			for (int i=left_index; i<=max_index; i++)
				if (height[i]<height[left_index])
					sum += height[left_index]-height[i];
			sum += helper(height, s, left_index);
		}
		if (right_index!=-1) {
			for (int i=max_index; i<=right_index; i++)
				if (height[i]<height[right_index])
					sum += height[right_index]-height[i];
			sum += helper(height, right_index, t);
		}
		return sum;
	}
	
	public int trap(int[] height) {
		int len = height.length;
		if (len == 0) return 0;
		return helper(height, 0, len-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] height = {};
		T42 t42 = new T42();
		System.out.println(t42.trap(height));
	}

}

















//public class Solution {
//    public int trap(int[] height) {
//    if (height.length == 0) return 0;
//    int [] startMax = new int[height.length];
//    int [] endMax = new int[height.length];
//    startMax[0] = height[0];
//    for (int i = 1; i < height.length; i ++)
//        startMax[i] = Math.max(startMax[i - 1], height[i]);
//    endMax[height.length - 1] = height[height.length - 1];
//    for (int i = height.length - 2; i >= 0; i --) {
//        endMax[i] = Math.max(endMax[i + 1], height[i]);
//    }
//
//    int sum = 0;
//    for (int i = 1; i < height.length - 1; i++) {
//        sum += Math.max(0, Math.min(startMax[i - 1], endMax[i + 1]) - height[i]);
//    }
//    return sum;
//}
//}