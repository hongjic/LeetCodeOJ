package T546;

public class Solution {

	public int removeBoxes(int[] boxes) {
		return removeBoxes(boxes, 0, boxes.length - 1);
	}
	
	private int removeBoxes(int[] boxes, int begin, int end) {
		if (end < begin) return 0;
		int headNumber = boxes[begin];
		int index = begin;
		while (index <= end && boxes[index] == headNumber) index ++;
		if (index > end) {
			//only headNumber
			return (end - begin + 1) * (end - begin + 1);
		}
		int headEnd = index - 1;
		while (index <= end && boxes[index] != headNumber) index ++;
		if (index > end) {
			// headNumber is now alltogether
			return (headEnd - begin + 1) * (headEnd - begin + 1) + removeBoxes(boxes, headEnd + 1, end);
		}
		// index point to the next part "headNumber"
		int notCombine = (headEnd -begin + 1) * (headEnd - begin + 1) + removeBoxes(boxes, headEnd + 1, end);
		int[] newBoxes = new int[headEnd - begin + 1 + end - index + 1];
		int count = 0;
		for (int i = begin; i <= headEnd; i ++)
			newBoxes[count ++] = boxes[i];
		for (int i = index; i <= end; i ++)
			newBoxes[count ++] = boxes[i];
		int combine = removeBoxes(boxes, headEnd + 1, index - 1) + removeBoxes(newBoxes, 0, newBoxes.length - 1); 
		return Math.max(notCombine, combine);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = new Solution().removeBoxes(new int[]{1,3,2,2,2,3,4,3,1});
		System.out.println(res);
	}

}
