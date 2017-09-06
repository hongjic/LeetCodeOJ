
import java.util.List;
import java.util.ArrayList;


public class TrieQuery {

	public static class TrieNode {
		char val;
		int words; // come to an end here
		TrieNode[] childrens;
		TrieNode(char c) {
			words = 0;
			val = c;
			childrens = new TrieNode[26];
		}
		
		void addChild(TrieNode child) {
			childrens[child.val - 97] = child;
		}
		
		boolean hasChild(char c) {
			return !(childrens[c - 97] == null);
		}
		
		TrieNode getChild(char c) {
			return childrens[c - 97];
		}
	}
	
	public static class Trie {
		public static class WordCount {
			private String matchStr;
			private int count;
			
			public WordCount(String s, int c) {
				matchStr = s;
				count = c;
			}
			
			@Override
			public String toString() {
				return matchStr + ": " + String.valueOf(count);
			}
		}
		
		private TrieNode root;
		
		public Trie() {
			root = new TrieNode('0');
		}
		
		public void addWord(String st) {
			TrieNode cur = root;
			int len = st.length();
			for (int i = 0; i < len; i ++) {
				if (cur.hasChild(st.charAt(i))) {
					cur = cur.getChild(st.charAt(i));
				}
				else {
					TrieNode node = new TrieNode(st.charAt(i));
					cur.addChild(node);
					cur = node;
				}
				if (i == len - 1) cur.words ++;
			}
		}
		
		public List<WordCount> queryWord(String query) {
			List<WordCount> queryResult = new ArrayList<WordCount>();
			if (query == null || query.length() == 0) 
				return queryResult;
			query(query, queryResult, 0, root, new StringBuffer());
			return queryResult;
		}
		
		private void query(String query, List<WordCount> result, int index, TrieNode node, StringBuffer word) {
			if (node != root) word.append(node.val);
			if (index == query.length()) {
				if (node.words > 0)
					result.add(new WordCount(word.toString(), node.words));
				word.deleteCharAt(word.length() - 1);
				return;
			}
			char cur = query.charAt(index);
			if (cur == '.') {
				for (int i = 0; i < 26; i ++) {
					char c = (char)(i + 97);
					if (node.hasChild(c))
						query(query, result, index + 1, node.getChild(c), word);
				}
			}
			else if (node.hasChild(cur))
				query(query, result, index + 1, node.getChild(cur), word);
			if (node != root) word.deleteCharAt(word.length() - 1);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie dictionary = new Trie();
		String[] words= {"facebook", "book", "googlebook", "notebook", "bookmicro", "microbook", "face", "book"};
		for (int i = 0; i < words.length; i ++)
			dictionary.addWord(words[i]);
		List<Trie.WordCount> queryResult = dictionary.queryWord("n..ebo..");
		if (queryResult.size() == 0) 
			System.out.println("No result.");
		else
			for (int i = 0; i < queryResult.size(); i ++)
				System.out.println(queryResult.get(i).toString());
	}

}
