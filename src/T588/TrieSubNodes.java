package T588;

import java.io.IOException;
import java.util.List;

public class TrieSubNodes implements SubNodes {

	private static class TrieNode {
		
		private static int NONE = 0;
		private static int DIR = 1;
		private static int FILE = 2;
		
		private char c;
		private TrieNode[] children;
		private int type; 
		
		public TrieNode(char c, int type) {
			this.c = c;
			this.type = type;
			children = new TrieNode[26];
		}
		
	}
	
	public TrieSubNodes() {
		TrieNode root = new TrieNode(' ', TrieNode.NONE);	
	}
	
	@Override
	public INode createSubNode(String nodeName, boolean isFile) throws IOException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public INode findSubNode(String nodeName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listAllSubNodeNames() {
		// TODO Auto-generated method stub
		return null;
	}

}