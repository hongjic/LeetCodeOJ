package T658;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int index = Collections.binarySearch(arr, x);
        LinkedList<Integer> res = new LinkedList<>();
        int left, right;
        if (index >= 0) {
            res.add(arr.get(index));
            left = index - 1; right = index + 1;
        }
        else {
            index = -index - 1;
            right = index; left = index - 1;
        }
        while (res.size() < k) {
            if (right == arr.size() || (left >= 0 && Math.abs(arr.get(left) - x) <= Math.abs(arr.get(right) - x)))
                res.addFirst(arr.get(left --));
            else
                res.addLast(arr.get(right ++));
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new Solution().findClosestElements(Arrays.asList(-1, 0, 1,2,3,4,6,8), 7, 5);
        for (int r: res)
            System.out.print(r + ", ");
    }

}
