package T12_56;
import java.util.ArrayList;
import java.util.List;


public class T52 {

	private int helper(List<Integer> qp, int index, int n, int sum) {
		if (index == n) 
			return sum + 1;
		for (int j = 0; j < n; j++) {
			boolean valid = true;
			for (int pre = 0; pre < index; pre++)
				if (qp.get(pre) == j || Math.abs(qp.get(pre) - j) == Math.abs(pre - index)) {
					valid = false;
					break;
				}
			if (!valid) continue;
			qp.add(j);
			sum = helper(qp, index + 1, n, sum);
			qp.remove(index);
		}
		return sum;
	}
	
	public int totalNQueens(int n) {
		if (n==0) return 0;
		if (n==1) return 1;
		List<Integer> q_positions = new ArrayList<Integer>();
		return helper(q_positions, 0, n, 0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		T52 t52 = new T52();
		System.out.println(t52.totalNQueens(n));
	}

}


//public class Solution {
//
//int sum = 0, upperlim = 1;
//
//public int totalNQueens(int n) {
//    upperlim = (upperlim << n) - 1; 
//    helper(0,0,0);
//    return sum;
//}
//
//void helper(int row, int ld, int rd){  
//    if (row != upperlim)  
//    {  
//        int pos = upperlim & ~(row | ld | rd);   
//        while (pos>0)
//        {  
//            int p = pos & -pos;                                                
//
//            pos -= p;                             
//
//            helper(row + p, (ld + p) << 1, (rd + p) >> 1);                                
//        }  
//    }else{
//        sum++;
//    }  
//}
//}