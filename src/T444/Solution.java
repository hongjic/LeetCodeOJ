package T444;

import java.util.*;

public class Solution {

    /*
    topological sort. time limit exceed.
     */
    public boolean sequenceReconstruction2(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (List<Integer> seq: seqs) {
            if (seq.size() > 0 && !inDegree.containsKey(seq.get(0)))
                inDegree.put(seq.get(0), 0);
            for (int i = 0; i < seq.size() - 1; i ++) {
                if (edges.computeIfAbsent(seq.get(i), k -> new HashSet<>()).add(seq.get(i + 1)))
                    inDegree.put(seq.get(i + 1), inDegree.getOrDefault(seq.get(i + 1), 0) + 1);
            }
        }

        if (inDegree.size() != n) return false;
        int[] construct = new int[n];
        int index = 0;
        while (index < n) {
            // find the node with indgree 0
            int point = 0;
            for (int i: inDegree.keySet())
                if (inDegree.get(i) == 0) {
                    if (point != 0) return false;
                    point = i;
                }
            if (point == 0) return false;
            construct[index ++] = point;
            inDegree.remove(point);
            if (edges.containsKey(point)) {
                Set<Integer> connects = edges.get(point);
                for (int c : connects)
                    if (inDegree.containsKey(c))
                        inDegree.put(c, inDegree.get(c) - 1);
            }
        }

        for (int i = 0; i < n; i ++)
            if (org[i] != construct[i])
                return false;
        return true;
    }

    /*
    check sufficient & necessary
     */
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        int[] pos = new int[n + 1];
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < n; i ++) {
            pos[org[i]] = i;
            numbers.add(org[i]);
        }

        Set<Integer> conseq = new HashSet<>();
        for (int i = 0; i < n - 1; i ++)
            conseq.add(org[i] * n + org[i + 1]);

        for (List<Integer> seq: seqs) {
            for (int i = 0; i < seq.size(); i ++) {
                if (seq.get(i) < 1 || seq.get(i) > n) return false;
                if (i > 0) {
                    if (pos[seq.get(i - 1)] >= pos[seq.get(i)]) return false;
                    conseq.remove(seq.get(i - 1) * n + seq.get(i));
                }
                numbers.remove(seq.get(i));
            }
        }

        return numbers.isEmpty() && conseq.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sequenceReconstruction(new int[] {1}, Arrays.asList(Arrays.asList(1), Arrays.asList(1), Arrays.asList(1))));
        System.out.println(new Solution().sequenceReconstruction(new int[] {4,1,5,2,6,3}, Arrays.asList(Arrays.asList(5,2,6,3), Arrays.asList(4,1,5,2))));
    }
}
