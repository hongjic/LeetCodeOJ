package T101_end;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class T347 {

	public List<Integer> topKRequent(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return null;
		Map<Integer, Integer> wordCount = new HashMap<Integer, Integer>();
		int len = nums.length;
		for (int i = 0; i < len; i ++)
			wordCount.put(nums[i], wordCount.getOrDefault(nums[i], 0) + 1);
		Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if (wordCount.get(a) < wordCount.get(b))
					return 1;
				if (wordCount.get(a) > wordCount.get(b))
					return -1;
				return 0;
			}
		});
		for (Integer word: wordCount.keySet()) 
			queue.offer(word);
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < k; i ++)
			result.add(queue.poll());
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T347 t347 = new T347();
		int[] list = {1,1,1,2,2,3};
		List<Integer> result = t347.topKRequent(list, 2);
		for (int i = 0 ; i < result.size(); i ++)
			System.out.print(result.get(i) + " ");
	}

}