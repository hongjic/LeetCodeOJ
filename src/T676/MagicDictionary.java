package T676;

public class MagicDictionary {

    private static class Node {
        Node[] children;
        int words;
        char val;

        public Node(char x) {
            words = 0;
            val = x;
            children = new Node[26];
        }

        public void addString(char[] str, int index) {
            if (index == str.length) {
                words ++;
                return;
            }
            char first = str[index];
            if (children[first - 97] == null)
                children[first - 97] = new Node(first);
            children[first - 97].addString(str, index + 1);
        }

        public boolean search(char[] str, int index) {
            if (index == str.length) {
                return words > 0;
            }
            char first = str[index];
            if (children[first - 97] == null)
                return false;
            return children[first - 97].search(str, index + 1);
        }
    }

    private Node root;

    public MagicDictionary() {
        root = new Node('#');
    }

    public void buildDict(String[] dict) {
        for (String str: dict) {
            root.addString(str.toCharArray(), 0);
        }
    }

    public boolean search(String word) {
        char[] str = word.toCharArray();
        for (int i = 0; i < str.length; i ++) {
            char origin = str[i];
            for (char c = 'a'; c <= 'z'; c ++)
                if (c != str[i]) {
                    str[i] = c;
                    if (root.search(str, 0)) return true;
                    str[i] = origin;
                }
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary dict = new MagicDictionary();
        dict.buildDict(new String[] {"hello", "leetcode"});
        System.out.println(dict.search("hello"));
        System.out.println(dict.search("hhllo"));
        System.out.println(dict.search("hell"));
        System.out.println(dict.search("leetcoded"));

    }
}
