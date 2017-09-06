package T57_100;

public class T66 {

	private int[] plusOne(int[] digits) {
		int len = digits.length, add = 1, i = len - 1;
		while (i >= 0 && add > 0) {
			digits[i] = digits[i] + add;
			if (digits[i] >= 10) 
				digits[i] -= 10;
			else
				add = 0;
			-- i;
		}
		if (add == 0) return digits; 
		int[] res = new int[len + 1];
		res[0] = 1;
		for (int j = 0; j < len; ++ j)
			res[j + 1] = digits[j];
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T66 t66 = new T66();
		int[] digits = { 9,9,9,9};
		int[] res = t66.plusOne(digits);
		for (int i = 0; i < res.length; ++ i)
			System.out.println(res[i]);
	}

}
