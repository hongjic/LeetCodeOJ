package T650;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenhongji on 2017/7/30.
 */
public class Solution {

    private static final int NONE = 0, COPY = 1, PASTE = 2;

    public static class Status {
        int num;
        int op;
        int copy;
        int step;
        public Status(int num, int op, int copy, int step) {
            this.num = num;
            this.op = op;
            this.copy = copy;
            this.step = step;
        }
    }

    public int minSteps(int n) {
        Queue<Status> queue = new LinkedList<Status>();
        queue.offer(new Status(1, NONE, 0, 0));
        while (true) {
            Status cur = queue.poll();
            if (cur.num > n) continue;
            if (cur.num == n) return cur.step;

            if (cur.op == NONE) {
                // COPY
                queue.offer(new Status(cur.num, COPY, cur.num, cur.step + 1));
            }
            if (cur.op == COPY) {
                // PASTE
                queue.offer(new Status(cur.num + cur.copy, PASTE, cur.copy, cur.step + 1));
            }
            if (cur.op == PASTE) {
                // COPY & PASTE
                queue.offer(new Status(cur.num, COPY, cur.num, cur.step + 1));
                queue.offer(new Status(cur.num + cur.copy, PASTE, cur.copy, cur.step + 1));
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(new Solution().minSteps(n));
    }
}
