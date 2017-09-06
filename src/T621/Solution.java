package T621;

import java.util.*;

public class Solution {

    /*
    Just greedy. Place the most common tasks first.
     */
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char task: tasks)
            counter.put(task, counter.getOrDefault(task, 0) + 1);
        int taskNum = counter.size();

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(counter.entrySet());
        Collections.sort(list, ((e1, e2) -> e2.getValue() - e1.getValue()));

        int groupNum = list.get(0).getValue(), max = groupNum; // max -> number of most common tasks
        int[] groups = new int[groupNum];

        int k = 1;
        while (k < taskNum && list.get(k).getValue() == max) k ++;

        Arrays.fill(groups, k);
        int roundRobin = 0;

        for (int i = k; i < taskNum; i ++) {
            int dup = list.get(i).getValue();
            for (int j = 0; j < dup; j ++, roundRobin ++, roundRobin %= (groupNum - 1))
                groups[roundRobin] ++;
        }

        int res = 0;
        for (int i = 0; i < groupNum; i ++)
            if (i == groupNum - 1)
                res += groups[i];
            else
                res += Math.max(groups[i], n + 1);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().leastInterval("AAABBB".toCharArray(), 2));
        System.out.println(new Solution().leastInterval("AAAAABBBBCCCDE".toCharArray(), 2));
        System.out.println(new Solution().leastInterval("AAAAAABCDEFG".toCharArray(), 2));
    }
}
