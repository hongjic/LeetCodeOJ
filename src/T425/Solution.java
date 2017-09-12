package T425;

import java.util.*;

public class Solution {

    private static class Trie {

        private static class NodeSuffixIterator implements Iterator<String> {

            private Stack<Node> stack = new Stack<>();
            private StringBuilder sb = new StringBuilder();

            public NodeSuffixIterator(Node node) {
                if (node == null) return;
                while (!node.leaf) {
                    if (!stack.empty()) sb.append(node.val);
                    stack.push(node);
                    node = node.findChildAfter((char)('a' - 1));
                }
                stack.push(node);
                sb.append(node.val);
                //stack size >= 2 after initialization
            }

            @Override
            public boolean hasNext() {
                return sb.length() > 0;
            }

            @Override
            public String next() {
                String res = sb.toString();
                Node node = stack.pop(), parent = stack.peek();
                sb.deleteCharAt(sb.length() - 1);

                Node next;
                while ((next = parent.findChildAfter(node.val)) == null && stack.size() > 1) {
                    node = stack.pop();
                    parent = stack.peek();
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (stack.size() == 1 && next == null) return res;

                while (!next.leaf) {
                    stack.push(next);
                    sb.append(next.val);
                    next = next.findChildAfter((char) ('a' - 1));
                }
                stack.push(next);
                sb.append(next.val);
                return res;
            }
        }

        // an optimization could be just storing all the words starting with the same prefix in each node when you construct the Trie
        // then you don't need SuffixIterator to construct every possible match durng search.
        private static class Node {

            boolean leaf;
            Node[] children;
            char val;

            public Node(char x) {
                val = x; leaf = false;
                children = new Node[26];
            }

            public void addString(char[] str, int index) {
                if (index == str.length) {
                    leaf = true;
                    return;
                }
                char c = str[index];
                if (children[c - 97] == null)
                    children[c - 97] = new Node(c);
                children[c - 97].addString(str, index + 1);
            }

            public Node getChild(char c) {
                return children[c - 97];
            }

            public NodeSuffixIterator getSuffixIterator() {
                return new NodeSuffixIterator(this);
            }

            public Node findChildAfter(char x) {
                for (char c = (char)(x + 1); c <= 'z'; c ++)
                    if (children[c - 'a'] != null)
                        return children[c - 'a'];
                return null;
            }
        }

        private Node root;

        public Trie() {
            root = new Node('#');
        }

        public void addString(String word) {
            root.addString(word.toCharArray(), 0);
        }

        public Iterator<String> getIteratorBasedOnPrefix(String prefix) {
            Node node = root;
            int index = 0;
            while (index < prefix.length()) {
                node = node.getChild(prefix.charAt(index ++));
                if (node == null) return new NodeSuffixIterator(null);
            }
            return node.getSuffixIterator();
        }
    }

    private Trie trie;
    int n; // size of the matrix

    public List<List<String>> wordSquares(String[] words) {
        trie = new Trie();
        n = words[0].length();

        for (String word: words)
            trie.addString(word);
        List<List<String>> results = new ArrayList<>();
        String[] result = new String[n];

        for (String first: words) {
            result[0] = first;
            findWordSquares(result, 1, results);
        }
        return results;
    }

    private void findWordSquares(String[] cur, int index, List<List<String>> results) {
        if (index == n) {
            List<String> result = new ArrayList<>();
            for (String word: cur)
                result.add(word);
            results.add(result);
            return;
        }
        StringBuilder prefixBuilder = new StringBuilder();
        for (int i = 0; i < index; i ++) {
            prefixBuilder.append(cur[i].charAt(index));
        }

        String prefix = prefixBuilder.toString();
        Iterator<String> iter = trie.getIteratorBasedOnPrefix(prefix);
        while (iter.hasNext()) {
            String curLine = prefix + iter.next();
            cur[index] = curLine;
            findWordSquares(cur, index + 1, results);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"abaa", "aaab", "baaa", "aaba"};
        List<List<String>> res = solution.wordSquares(words);
        for (List<String> list: res) {
            for (String word: list)
                System.out.print(word + ", ");
            System.out.println();
        }

//        Trie trie = new Trie();
//        for (String word: words) {
//            trie.addString(word);
//        }
//        Iterator<String> iter = trie.getIteratorBasedOnPrefix("a");
//        while (iter.hasNext()) {
//            System.out.println("a" + iter.next());
//        }

    }
}
