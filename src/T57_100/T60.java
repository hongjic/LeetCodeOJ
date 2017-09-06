package T57_100;

import java.util.ArrayList;
import java.util.List;

public class T60 {

	public String getPermutation(int n, int k) {
		if (n == 0) return "";
		StringBuffer res = new StringBuffer();
		int[] base = new int[n];//每一位的基数
		int s = 1;
		for (int i = 0; i < n; i ++) {
			base[i] = s;
			s *= i + 1;
		}
		int kk = k, i;
		int[] t = new int[n]; // 每一位的倍数
		for (i = n - 1; i >= 0; i--) {
			t[i] = kk / base[i];
			kk -= t[i] * base[i];
			if (kk == 0) break;
		}
		int end = i; // the end of "not 0 in t"
		boolean[] used = new boolean[n + 1]; // 0位作废从1开始共len个
		for (i = n - 1; i >= end; i --) {
			int min_index = t[i]; //当前寻找的第min_index小的未用过的数
			if (i != end) min_index ++;
			int j = 1;
			while (j <= n) {
				if (!used[j]) min_index --;
				if (min_index == 0) break;
				j ++;
			}
			used[j] = true;
			res.append((char)(j + 48));
		}
		for (i = n; i >= 1; i --)
			if (!used[i]) res.append((char)(i + 48));
		return res.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T60 t60 = new T60();
		System.out.println(t60.getPermutation(0, 1));
	}

}














//public class Solution {
//    public String getPermutation(int n, int k) {
//        StringBuilder res = new StringBuilder();
//        ArrayList<Integer> nums = new ArrayList<Integer>();
//        int remain = n;
//        int[] fac = new int[n];
//        for (int i = 0; i < n; i++) {
//            if (i == 0) {
//                fac[i] = 1;
//            } else {
//                fac[i] = fac[i - 1] * (i + 1);
//            }
//            nums.add(i + 1);
//        }
//        k--;
//        while (k > 0) {
//            int index = k / fac[remain - 2];
//            res.append(nums.get(index));
//            nums.remove(index);
//            k = k % fac[remain - 2];
//            remain--;
//        }
//
//        for (int i = 0; i < nums.size(); i ++) {
//            res.append(nums.get(i));
//        }
//        return res.toString();
//    }
//}