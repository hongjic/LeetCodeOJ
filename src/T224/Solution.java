package T224;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    private static Map<Character, Integer> priority;

    static {
        priority = new HashMap<>();
        priority.put('(', 2);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put(')', 2);
    }

    private void execute(int p, Stack<Character> ops, Stack<Integer> nums) {
        if (ops.size() == 0 || priority.get(ops.peek()) < p)
            return;

        char topOp = ops.peek();
        if (topOp == '(') return;
        if (topOp == '+') {
            nums.push(nums.pop() + nums.pop());
            ops.pop();
        }
        else if (topOp == '-') {
            if (nums.size() == 1) // negative number
                nums.push(-nums.pop());
            else // minus operation
                nums.push(-nums.pop() + nums.pop());
            ops.pop();
        }
        else if (topOp == ')') {
            ops.pop();
            while (topOp != '(') {
                if (topOp == '+') nums.push(nums.pop() + nums.pop());
                if (topOp == '-') nums.push(-nums.pop() + nums.pop());
                topOp = ops.pop();
            }
        }
        execute(p, ops, nums);
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        int len = s.length(), i = 0;

        while (i < len) {
            if (s.charAt(i) == ' ') {
                i ++;
                continue;
            }

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = 0;
                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i ++;
                }
                nums.push(num);
            }
            else {
                char newOp = s.charAt(i ++);
                int p = priority.get(newOp);
                execute(p, ops, nums);
                ops.push(newOp);
            }
        }

        execute(0, ops, nums);
        return nums.pop();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.calculate("(-1+(4+5+2)-3)+(6+8)"));
    }
}
