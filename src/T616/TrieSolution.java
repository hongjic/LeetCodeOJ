package T616;

import java.util.HashMap;
import java.util.Map;

/*
This solution use Trie
time complexity O(kn + mn)
k: number of strings in dict
m: length of original string
n: length of strings in dict
 */
public class TrieSolution {

    private static class Trie {

        private Node root;

        private static class Node {
            char val;
            Map<Character, Node> children = new HashMap<>();
            boolean leaf;

            public Node(char c) {
                val = c; leaf = false;
            }

            public boolean contains(char c) {
                return children.containsKey(c);
            }

            public void addNode(Node node) {
                children.put(node.val, node);
            }

            public Node getNode(char c) {
                return children.get(c);
            }

        }

        public Trie() {
            root = new Node(' ');
        }

        public void addString(String str) {
            Node node = root;
            for (char c: str.toCharArray()) {
                if (!node.contains(c)) {
                    Node newNode = new Node(c);
                    node.addNode(newNode);
                    node = newNode;
                }
                else
                    node = node.getNode(c);
            }
            node.leaf = true;
        }

        public int findLogestMatch(String str, int start) {
            int index = start, maxLen = 0, len = 0;
            Node node = root;
            while (index < str.length()) {
                if (node.leaf)
                    maxLen = Math.max(maxLen, len);
                if (node.contains(str.charAt(index))) {
                    node = node.getNode(str.charAt(index ++));
                    len ++;
                }
                else break;
            }
            if (node.leaf)
                maxLen = Math.max(maxLen, len);
            return maxLen;
        }
    }

    public String addBoldTag(String s, String[] dict) {
        Trie trie = new Trie();
        for (String str: dict)
            trie.addString(str);

        int size = s.length();
        boolean[] bold = new boolean[size];

        for (int i = 0; i < s.length(); i ++) {
            int maxLen = trie.findLogestMatch(s, i);
            for (int j = 0; j < maxLen; j ++)
                bold[i + j] = true;
        }

        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i < size) {
            if (!bold[i])
                builder.append(s.charAt(i ++));
            else {
                builder.append("<b>");
                while (i < size && bold[i]) {
                    builder.append(s.charAt(i ++));
                }
                builder.append("</b>");
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new TrieSolution().addBoldTag("aaabbcc", new String[] {"aaa", "aab", "bc"}));
        System.out.println(new TrieSolution().addBoldTag("abcxyz123", new String[] {"abc", "123"}));
    }
}
