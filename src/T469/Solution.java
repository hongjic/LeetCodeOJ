package T469;

import java.util.*;

/*
Using corss product. all sin(angles) must has the same sign.
 */
public class Solution {

    private int getAngle(int[] edge1, int[] edge2) {
        return edge1[0] * edge2[1] - edge1[1] * edge2[0];
    }

    private int[] getEdge(List<Integer> p1, List<Integer> p2) {
        return new int[] {p2.get(0) - p1.get(0), p2.get(1) - p1.get(1)};
    }

    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        int[] preEdge = getEdge(points.get(n - 1), points.get(0));
        int preAngle = 0;
        for (int i = 0; i < n; i ++) {
            int[] edge = getEdge(points.get(i), points.get( (i + 1) % n ));
            int angle = getAngle(preEdge, edge);
            if (preAngle == 0)
                preAngle = angle;
            else {
                if (angle > 0 && preAngle < 0 || angle < 0 && preAngle > 0) return false;
            }
            preEdge = edge;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isConvex(Arrays.asList(Arrays.asList(0,0), Arrays.asList(0,1), Arrays.asList(1,1), Arrays.asList(1,0))));
        System.out.println(new Solution().isConvex(Arrays.asList(Arrays.asList(0,0), Arrays.asList(0,10), Arrays.asList(10, 10), Arrays.asList(10,0), Arrays.asList(5,5))));
    }
}
