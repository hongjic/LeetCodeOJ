package T324;

/*
Hard question mistakenly marked as middle.
1) frist use quickSelect to find the median.
2) Use the median as a classifier to do three-way paritition (based on virtual index).
    Numbers bigger than median are on its left, numbers smaller than median are on its right.
    (like sort colors)

3) Apply virtual indexing when doing three-way parition.
In this case, `left`, `i` and `right` are virtual index.
To get the real index, invoke realIndex(v_index, n)
For example:
Accessing A(0) actually accesses nums[1].
Accessing A(1) actually accesses nums[3].
Accessing A(2) actually accesses nums[5].
Accessing A(3) actually accesses nums[7].
Accessing A(4) actually accesses nums[9].
Accessing A(5) actually accesses nums[0].
Accessing A(6) actually accesses nums[2].
Accessing A(7) actually accesses nums[4].
Accessing A(8) actually accesses nums[6].
Accessing A(9) actually accesses nums[8]
 */

public class Solution {

    private int findKthLargest(int[] nums, int k, int left, int right) {
        if (left == right)
            return nums[left];
        int mid = left + (right - left) / 2;
        int pivot = nums[mid];
        nums[mid] = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] > pivot) j --;
            if (i == j) break;
            nums[i] = nums[j]; i ++;
            while (i < j && nums[i] < pivot) i ++;
            if (i == j) break;
            nums[j] = nums[i]; j --;
        }
        nums[i] = pivot;
        if (i == k) return nums[i];
        if (i > k) return findKthLargest(nums, k, left ,i - 1);
        return findKthLargest(nums, k, i + 1, right);
    }

    private int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k - 1, 0, nums.length - 1);
    }

    private int realIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }

    public void wiggleSort(int[] nums) {
        int k = (nums.length + 1) / 2;
        int median = findKthLargest(nums, k);

        // apply virtual indexing
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i ++) {
            while (nums[realIndex(i, nums.length)] < median && i < right)
                swap(nums, realIndex(i, nums.length), realIndex(right --, nums.length));
            while (nums[realIndex(i, nums.length)] > median && i > left)
                swap(nums, realIndex(i, nums.length), realIndex(left ++, nums.length));
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2, 1, 2, 2, 1};
        new Solution().wiggleSort(nums);
        for (int num: nums)
            System.out.print(num + ", ");
        System.out.println();
    }

}
