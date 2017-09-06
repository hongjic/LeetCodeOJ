package T418;

/*
 * beat 99.53%  7ms
 */

public class Solution {

	public int wordsTyping(String[] sentence, int rows, int cols) {
		int lenSum = 0;
		for (int i = 0; i < sentence.length; i ++)
			lenSum += sentence[i].length() + 1;
		
		int words = sentence.length;
		// nextIndex[i] = j means if sentence[i] is the starting word of one line, then next line will start with sentence[j]
		// wordCount[i] = j means the lines start with sentence[i] will pass the last word j times.
		int[] nextIndex = new int[words];
		int[] wordCount = new int[words];
		for (int i = 0; i < words; i ++) {
			int count = 0, len = sentence[i].length(), j = i;
			while (len <= cols) {
				j ++;
				if (j == sentence.length) {
					j = 0;
					int rounds = (cols - len) / lenSum;
					count += rounds + 1;
					len += rounds * lenSum;
				}
				len += 1 + sentence[j].length();
			}
			nextIndex[i] = j;
			wordCount[i] = count;
		}
		
		int index = 0, result = 0;
		for (int i = 0; i < rows; i ++) {
			result += wordCount[index];
			index = nextIndex[index];
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println("test1:" + (s.wordsTyping(new String[] {"hello", "world"}, 2, 8) == 1 ? true : false));
		System.out.println("test2:" + (s.wordsTyping(new String[] {"hello", "world"}, 100, 2) == 0 ? true : false));
		System.out.println("test3:" + (s.wordsTyping(new String[] {"a", "bcd", "e"}, 3, 6) == 2 ? true : false));
		System.out.println("test3:" + (s.wordsTyping(new String[] {"a", "b", "e"}, 20, 20) == 66 ? true : false));
	}

}
