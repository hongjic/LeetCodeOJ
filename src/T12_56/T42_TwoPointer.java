package T12_56;
public class T42_TwoPointer {
	//this solution beats 90%
	public int trap(int[] height) {
		int len = height.length;
		if (len==0) return 0;
		int max = height[0], sum = 0, max_index = 0, i = 0;
		// from left to right
		while (i<len) {
			while (i>0 && i<=len-1 && height[i]==height[i-1])
				i++;
			if (i == len) break;
			if (height[i]>=max) {
				//add to sum and update max info
				for (int j=max_index; j<i; j++) {
					sum += max-height[j];
					height[j] = max;
				}
				max = height[i];
				max_index = i;
			}
			i++;
		}
		// from right to left
		i = len-1; max = height[i]; max_index = i;
		while (i>=0) {
			while (i>=0 && i<len-1 && height[i]==height[i+1])
				i--;
			if (i<0) break;
			if (height[i]>=max) {
				//add to sum and update max info
				for (int j=max_index; j>i; j--)
					sum += max-height[j];
				max = height[i];
				max_index = i;
			}
			i--;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T42_TwoPointer t42 = new T42_TwoPointer();
		int[] height = {0,2,0,2,0,2,0,2,0,2,0,2};
		System.out.println(t42.trap(height));
	}

}

// //another solution using two points from left and right.
//public class Solution {
//public int trap(int[] height) {
//	 if(height == null || height.length <= 2) return 0;
//    
//    int sum = 0, maxhigh = 0;
//    int begin = 0, end = height.length-1;
//    while(begin <= end){
//        if(height[begin] <= maxhigh){
//            sum += maxhigh - height[begin++];
//        }
//        else if(height[end] <= maxhigh){
//            sum += maxhigh - height[end--];
//        }
//        else{
//            maxhigh = Math.min(height[begin], height[end]);
//        }
//    }
//    return sum;
//}
//}