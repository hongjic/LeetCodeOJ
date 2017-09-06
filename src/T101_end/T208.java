package T101_end;



public class T208 {
	
	private static class TrieNode {
		
		private char val;
		private TrieNode[] sons;
		private boolean exist;
		
		public TrieNode() {
			this.sons = new TrieNode[26];
			this.exist = false;
		}
		
		public void setVal(char val) {
			this.val = val;
		}
		
		public void setExist(boolean e) {
			this.exist = e;
		}
		
		public boolean addSon(TrieNode son) {
			if (!containsSon(son.val)) {
				sons[son.val - 97] = son;
				return true;
			}
			return false;
		}
		
		public boolean containsSon(char sonVal) {
			return !(sons[sonVal - 97] == null);
		}
		
		public TrieNode getSon(char sonVal) {
			return sons[sonVal - 97];
		}
		
		public boolean isExist() {
			return this.exist;
		}
	}
	
	private static class Trie {
		private TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void insert(String word) {
			int len = word.length();
			TrieNode cur = root;
			for (int i = 0; i < len; i ++) {
				char c = word.charAt(i);
				if (cur.containsSon(c)) {
					cur = cur.getSon(c);
					if (i == len - 1)
						cur.setExist(true);
				}
				else {
					TrieNode son = new TrieNode();
					son.setVal(c);
					if (i == len - 1)
						son.setExist(true);
					else son.setExist(false);
					cur.addSon(son);
					cur = son;
				}
			}
		}
		
		public boolean search(String word) {
			int len = word.length();
			TrieNode cur = root;
			for (int i = 0; i < len - 1; i ++) {
				char c = word.charAt(i);
				if (!cur.containsSon(c))
					return false;
				cur = cur.getSon(c);
			}
			char last = word.charAt(len - 1);
			cur = cur.getSon(last);
			if (cur == null) return false;
			else if (cur.isExist()) return true;
			return false;
		}
		
		public boolean startsWith(String prefix) {
			int len = prefix.length();
			TrieNode cur = root;
			for (int i = 0; i < len; i ++) {
				char c = prefix.charAt(i);
				if (!cur.containsSon(c))
					return false;
				cur = cur.getSon(c);
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("aaaaaa");
		trie.insert("aaaaaa");
		trie.insert("aaaaaa");
		trie.insert("aaaa");
		trie.insert("aaaaaaaaa");
		System.out.println(trie.search("a"));
		System.out.println(trie.startsWith("a"));
	}

}
