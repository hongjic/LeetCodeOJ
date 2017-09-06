package T488;

public class Solution {

	int min;
	
	public int findMinStep(String board, String hand) {
		min = Integer.MAX_VALUE;
		traverse(board, hand, 0);
		if (min == Integer.MAX_VALUE) return -1;
		return min;
	}
	
	private void traverse(String board, String hand, int index) {
		if (board.length() == 0 && index < min) min = index;
		if (hand.length() == 0) return;
		StringBuilder hsb = new StringBuilder(hand);
		for (int i = 0; i < hand.length(); i ++) {
			char ball = hand.charAt(i);
			hsb.deleteCharAt(i);
			int pos = 0; 
			while (pos < board.length()) {
				StringBuilder sb = new StringBuilder(board);
				while (pos < board.length() && board.charAt(pos) != ball) pos ++;
				sb.insert(pos, ball);
				removeConsecutive(sb);
				traverse(sb.toString(), hsb.toString(), index + 1);
				while (pos < board.length() && board.charAt(pos) == ball) pos ++;
			}
			hsb.insert(i, ball);
		}
	}
	
	public void removeConsecutive(StringBuilder sb) {
		int i = 0; 
		while (i < sb.length()) {
			char c = sb.charAt(i);
			int count = 0;
			while (i < sb.length() && sb.charAt(i) == c) {
				count ++; i++;
			}
			if (count >= 3) {
				sb.delete(i - count, i);
				if (sb.length() == 0) return;
				removeConsecutive(sb);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().findMinStep("BRYRBB",  "RYGYR"));
	}

}
