package T565;

public class Solution {

    public int arrayNesting(int[] nums) {
        int N = nums.length;
        boolean[] visited = new boolean[N];

        int point = 0, max = 0;
        while (point < N) {
            if (visited[point]) {
                point ++;
                continue;
            }

            visited[point] = true;
            int next = nums[point], count = 1;
            while (next != point) {
                visited[next] = true;
                count ++;
                next = nums[next];
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrayNesting(new int[] {5,4,0,3,1,6,2}));
        System.out.println(new Solution().arrayNesting(new int[] {0}));
    }
}
