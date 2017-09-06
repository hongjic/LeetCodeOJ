package T362;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    private Queue<Integer> buffer;
    private int count;

    public HitCounter() {
        buffer = new LinkedList<>();
        count = 0;
    }

    private void removeExpired(int timestamp) {
        while (!buffer.isEmpty() && buffer.peek() <= timestamp - 300) {
            buffer.poll();
            count --;
        }
    }

    /** Record a hit.
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        removeExpired(timestamp);
        buffer.offer(timestamp);
        count ++;
    }

    /** Return the number of hits in the past 5 minutes.
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        removeExpired(timestamp);
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        counter.getHits(4);
        counter.hit(300);
        counter.getHits(300);
        counter.getHits(301);

    }

}
