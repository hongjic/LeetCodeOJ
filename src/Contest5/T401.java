package Contest5;

import java.util.ArrayList;
import java.util.List;

public class T401 {

	private static void helper(int num, int sum, int dep, int[] on, List<String> res) {
		if (dep == 10) {
			if (sum < num) return;
			int hour = on[9]*8+on[8]*4+on[7]*2+on[6];
			if (hour >= 12) return;
			int minute = on[5]*32+on[4]*16+on[3]*8+on[2]*4+on[1]*2+on[0];
			if (minute >= 60) return;
			res.add(String.valueOf(hour) + ':' + (minute < 10 ? ('0' + String.valueOf(minute)) : String.valueOf(minute)));
			return;
		}
		if (sum < num) {
			on[dep] = 1;
			helper(num, sum+1, dep+1, on ,res);
			on[dep] = 0;
		}
		helper(num, sum, dep+1, on, res);
	}
	
	private static List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<String>();
		if (num > 10) return res;
		int[] on = new int[10];
		helper(num, 0, 0, on, res);
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = readBinaryWatch(2);
		for (int i = 0; i < list.size(); i ++)
			System.out.println(list.get(i));
	}

}
