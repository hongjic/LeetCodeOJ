package T307;


/*
Because the number of calls to update and sumrange funciton is distrbuted evenly.
So the time complexity should not have big difference
Both O(logn) using the concept of segment tree
 */
public class NumArray {

    private static class Node {
        int val;
        boolean leaf;
        Node left, right;
        int begin, end;

        public Node(int b, int e) {
            leaf = false;  // default is not leaf
            begin = b; end = e;
        }

        public int update(int i, int newVal) {
            if (i < begin || i > end) return 0;
            if (leaf) {
                int r = newVal - val;
                val = newVal;
                return r;
            }
            int d = 0;
            if (left != null) d += left.update(i, newVal);
            if (right != null) d += right.update(i, newVal);
            val += d;
            return d;
        }

        public int sumRange(int i, int j) {
            if (i <= begin && end <= j) return val;
            if (j < begin || i > end) return 0;
            int sum = 0;
            if (left != null) sum += left.sumRange(i, j);
            if (right != null) sum += right.sumRange(i, j);
            return sum;
        }
    }

    private Node root;

    private Node constructSegmentTree(int[] nums, int begin, int end) {
        Node node = new Node(begin, end);
        if (begin == end) {
            node.leaf = true;
            node.val = nums[begin];
            return node;
        }

        int mid = (begin + end) / 2;
        node.left = constructSegmentTree(nums, begin, mid);
        node.right = constructSegmentTree(nums, mid + 1, end);
        node.val = node.left.val + node.right.val;
        return node;
    }

    public NumArray(int[] nums) {
        if (nums.length > 0)
            root = constructSegmentTree(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        root.update(i, val);
    }

    public int sumRange(int i, int j) {
        return root.sumRange(i, j);
    }

    public static void main(String[] args) {
        NumArray arr = new NumArray(new int[] {});
        System.out.println(arr.sumRange(0, 2));
        arr.update(1, 2);
        System.out.println(arr.sumRange(0, 2));
    }
}
