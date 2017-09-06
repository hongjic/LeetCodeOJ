package T297;

public class Codec {
	
	private void serializeHelper(TreeNode root, StringBuffer sb) {
		sb.append(root.val);
		sb.append(':');
		sb.append(root.left == null ? 0 : 1);
		sb.append(root.right == null ? 0 : 1);
		sb.append(' ');
		if (root.left != null) serializeHelper(root.left, sb);
		if (root.right != null) serializeHelper(root.right, sb);
	}
	
	public TreeNode deserializeHelper(StringBuffer sb) {
		StringBuffer val = new StringBuffer();
		int i = 0; 
		while (i < sb.length() && sb.charAt(i) != ':') { 
			val.append(sb.charAt(i));
			i ++;
		}
		if (i == sb.length()) return null;
		TreeNode root = new TreeNode(Integer.parseInt(val.toString()));
		char left = sb.charAt(i + 1), 
			right = sb.charAt(i + 2);
		sb.delete(0, i + 4);
		if (left == '1')
			root.left = deserializeHelper(sb);
		if (right == '1')
			root.right = deserializeHelper(sb);
		return root;
	}

	public String serialize(TreeNode root) {
		if (root == null) return "";
		StringBuffer sb = new StringBuffer();
		serializeHelper(root, sb);
		return sb.toString();
	}
	
	public TreeNode deserialize(String data) {
		StringBuffer sb = new StringBuffer(data);
		return deserializeHelper(sb);
	}
	
	public static void main(String[] args) {
		Codec codec = new Codec();
		TreeNode node1 = new TreeNode(1),
				node2 = new TreeNode(2),
				node3 = new TreeNode(3),
				node4 = new TreeNode(4),
				node5 = new TreeNode(5),
				node6 = new TreeNode(6);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		node4.right = node6;
		String st = codec.serialize(null);
		System.out.println(st);
		TreeNode root = codec.deserialize(st);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.right.left.val);
		System.out.println(root.right.right.val);
		System.out.println(root.right.left.right.val);
		
		
	}

}
