package T12_56;


public class T45 {

	public int jump(int[] nums) {
		int len = nums.length;
		if (len<=1) return 0;
		//initialization
		//f[i] means the mininum steps required to reach the end
		int[] f = new int[len];
		for (int i=0; i<len; i++)
			f[i] = len+1;
		f[0]=0;
		int i=0,j=1;
		while (i<len) {
			if (f[i]+1<f[len-1]) {
				while (j<=i+nums[i] && j<len) {
					if (f[i]+1<f[j])
						f[j] = f[i]+1;
					j++;
				}
				if (j==len) return f[len-1];
			}
			i++;
		}
		return f[len-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T45 t45 = new T45();
		int[] nums = {2,1};
		System.out.println(t45.jump(nums));
	}

}
