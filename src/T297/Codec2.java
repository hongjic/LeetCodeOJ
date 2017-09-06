package T297;

import java.util.ArrayList;
import java.util.List;

public class Codec2 {

    public TreeNode deserialize(String data) {
		if (data.equals("[]")) return null;
		String[] v = data.substring(1, data.length() - 1).split(",");
		int i = 1;
		List<TreeNode> level = new ArrayList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(v[0]));
		level.add(root);
		while (i < v.length) {
			List<TreeNode> next = new ArrayList<TreeNode>();
			for (int j = 0; j < level.size(); j ++) {
				if (v[i].equals("null")) level.get(j).left = null;
				else {
					TreeNode node = new TreeNode(Integer.parseInt(v[i]));
					next.add(node);
					level.get(j).left = node;
				}
				i ++;
				if (v[i].equals("null")) level.get(j).right = null;
				else {
					TreeNode node = new TreeNode(Integer.parseInt(v[i]));
					next.add(node);
					level.get(j).right = node;
				}
				i ++;
			}
			level = next; 
		}
		return root;
	}
	
	public String serialize(TreeNode root) {
		if (root == null) return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		List<TreeNode> level = new ArrayList<TreeNode>();
		level.add(root);
		boolean bottom = false;
		while (!bottom) {
			List<TreeNode> next = new ArrayList<TreeNode>();
			bottom = true;
			for (int i = 0; i < level.size(); i ++) {
				if (level.get(i) == null) {
					sb.append("null,");
					continue;
				}
				if (level.get(i).left != null || level.get(i).right != null) bottom = false;
				sb.append(level.get(i).val).append(',');
				next.add(level.get(i).left);
				next.add(level.get(i).right);
			}
			level = next;
		}
		sb.deleteCharAt(sb.length() - 1).append(']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Codec2 codec = new Codec2();
		String data = "[1,null,2,3,null,4,5,6,7,null,8,null,null,9]";
		TreeNode root = codec.deserialize(data);
		System.out.println(codec.serialize(root));
	}

}
