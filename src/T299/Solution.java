package T299;

public class Solution {

	public String getHint(String secret, String guess) {
		int[] s = new int[10];
		int[] g = new int[10];
		int bulls = 0, cows = 0, len = secret.length();
		for (int i = 0; i < len; i ++) {
			s[secret.charAt(i) - 48] ++;
			g[guess.charAt(i) - 48] ++;
		}
		for (int i = 0; i < 10; i ++)
			cows += Math.min(s[i], g[i]);
		for (int i = 0; i < secret.length(); i ++)
			if (secret.charAt(i) == guess.charAt(i)) { 
				bulls ++;
				cows --;
			}
		return String.format("%dA%dB", bulls, cows);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().getHint("1807", "7810"));
	}

}
