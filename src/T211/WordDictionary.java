package T211;

public class WordDictionary {

	private TrieNode root;
	
	public static class TrieNode {
		char val;
		boolean isLeaf;
		TrieNode[] children;
		TrieNode(char c) {
			val = c;
			isLeaf = false;
			children = new TrieNode[26]; 
		}
		boolean hasChild(char c) {
			return children[c - 97] == null ? false : true;
		}
		TrieNode getChild(char c) {
			return children[c - 97];
		}
		boolean addChild(char c, TrieNode node) {
			if (hasChild(c)) return false;
			children[c - 97] = node;
			return true;
		}
	}
	
	public WordDictionary() {
		root = new TrieNode('0');
	}
	
	public void addWord(String word) {
		char[] arr = word.toCharArray();
		TrieNode node = root;
		for (char c: arr) {
			if (node.hasChild(c)) {
				node = node.getChild(c);
			}
			else {
				TrieNode t = new TrieNode(c);
				node.addChild(c, t);
				node = t;
			}
		}
		node.isLeaf = true;
	}
	
	public boolean search(String word) {
		return searchTrie(word, 0, root);
	}
	
	private boolean searchTrie(String word, int index, TrieNode node) {
		if (index == word.length()) {
			if (node.isLeaf) return true;
			return false;
		}
		// index < word.length();
		char c = word.charAt(index);
		if  (c == '.') {
			for (char child = 'a'; child < 'z'; child ++) {
				if (node.hasChild(child) && searchTrie(word, index + 1, node.getChild(child)))
					return true;
			}
			return false;
		}
		if (!node.hasChild(c)) return false;
		return searchTrie(word, index + 1, node.getChild(c));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary dict = new WordDictionary();
		dict.addWord("word");
		System.out.println(dict.search("pattern"));
		System.out.println(dict.search("...."));
	}

}
