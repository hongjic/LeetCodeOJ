package T101_end;

import java.util.ArrayList;
import java.util.List;

public class T116 {

	private static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	public void connect(TreeLinkNode root) {
		if (root == null) return;
        List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        list.add(root);
        int i = 0, levelStart = 0, levelEnd = 0;
        while (i < list.size()) {
            TreeLinkNode cur = list.get(i);
            if (i != levelStart) {
                TreeLinkNode pre = list.get(i - 1);
                pre.next = cur;
            }
            if (cur.left != null) list.add(cur.left);
            if (cur.right != null) list.add(cur.right);
            if (i == levelEnd) {
                i ++;
                levelStart = i;
                levelEnd = list.size() - 1;
            }
            else i ++;
        }
    }
	
	public static void main(String[] args) {
		T116 t116 = new T116();
		TreeLinkNode n1 = new TreeLinkNode(1),
				n2 = new TreeLinkNode(2),
				n3 = new TreeLinkNode(3),
				n4 = new TreeLinkNode(4),
				n5 = new TreeLinkNode(5),
				n6 = new TreeLinkNode(6),
				n7 = new TreeLinkNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		t116.connect(n1);
		System.out.println(n1.next == null ? false : n1.next.val);
		System.out.println(n2.next == null ? false : n2.next.val);
		System.out.println(n3.next == null ? false : n3.next.val);
		System.out.println(n4.next == null ? false : n4.next.val);
		System.out.println(n5.next == null ? false : n5.next.val);
		System.out.println(n6.next == null ? false : n6.next.val);
		System.out.println(n7.next == null ? false : n7.next.val);
		//output
		
	}

}
