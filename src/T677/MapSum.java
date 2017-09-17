package T677;

import java.util.*;

public class MapSum {

    private static class Node {
        char value;
        Map<Character, Node> children;
        int sum;
        Integer count;
        Node parent;

        public Node(char x) {
            value = x; parent = null;
            children = new HashMap<>();
            sum = 0; count = null;
        }
    }

    private Node root;

    public MapSum() {
        root = new Node('#');
    }

    public void insert(String key, int val) {
        Node node = root;
        char[] arr = key.toCharArray();
        for (int i = 0; i < arr.length; i ++) {
            if (!node.children.containsKey(arr[i])) {
                Node n = new Node(arr[i]);
                n.parent = node;
                node.children.put(arr[i], n);
            }
            node = node.children.get(arr[i]);
        }

        int add = val - (node.count == null ? 0 : node.count);
        if (node.count == null)
            node.count = add;
        else
            node.count += add;

        while (node != null) {
            node.sum += add;
            node = node.parent;
        }
    }

    public int sum(String prefix) {
        if (prefix.length() == 0) return root.sum;
        char[] arr = prefix.toCharArray();
        Node node = root;
        for (int i = 0; i < arr.length; i ++) {
            if (!node.children.containsKey(arr[i])) return 0;
            node = node.children.get(arr[i]);
        }
        return node.sum;
    }

    public static void main(String[] args) {
        MapSum sum = new MapSum();
        sum.insert("aa", 3);
        sum.insert("a", 2);
        System.out.println(sum.sum("a"));
        sum.insert("aa", 2);
        System.out.println(sum.sum("a"));
        System.out.println(sum.sum(""));
        sum.insert("", 5);
        System.out.println(sum.sum(""));
        sum.insert("", 3);
        System.out.println(sum.sum(""));

    }
}
