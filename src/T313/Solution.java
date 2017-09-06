package T313;

import java.util.PriorityQueue;

class Candidate implements Comparable<Candidate> {

	int value;
	int primeIndex;
	
	public Candidate(int v, int i) {
		value = v; primeIndex = i;
	}
	
	@Override
	public int compareTo(Candidate other) {
		return value - other.value;
	}
	
}

public class Solution {

	// O(nlogk). this is the best solution theoretically, but in reality it's 58ms, 
	// a little slower than the solution without heap O(nk). which is 23ms.
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] res = new int[n];
		res[0] = 1;
		int k = primes.length, ri = 1;
		int[] index = new int[k];
		PriorityQueue<Candidate> minHeap = new PriorityQueue<Candidate>();
		// initialzie minHeap
		for (int i = 0; i < k; i ++)
			minHeap.offer(new Candidate(res[index[i]] * primes[i], i));
		for (int i = 1; i < n; i ++) {
			int value = minHeap.peek().value;
			res[ri ++] = value;
			while (minHeap.peek().value == value) {
				Candidate c = minHeap.poll();
				index[c.primeIndex] ++;
				c.value = primes[c.primeIndex] * res[index[c.primeIndex]];
				minHeap.offer(c);
			}
		}
		return res[n - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().nthSuperUglyNumber(12, new int[]{2,7,13,19}));
	}
}
