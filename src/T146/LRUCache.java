package T146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class DoublyLinkedKVList<K, V> {
        public class Node {
            K key;
            V value;
            Node prev, next;
            public Node(K k, V v) {
                key = k;
                value = v;
            }
        }
        private Node head;
        private Node end;

        public void moveToHead(Node node) {
            // delete node
            if (node.prev == null) return;
            node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
            else
                end = node.prev;
            // add to head
            node.next = head;
            node.prev = null;
            if (head != null)
                head.prev = node;
            else
                end = node;
            head = node;
        }

        public Node addToHead(K key, V value) {
            Node node = new Node(key, value);
            node.next = head;
            if (head != null)
                head.prev = node;
            else
                end = node;
            head = node;
            return head;
        }

        public Node removeEnd() {
            if (end == null) return null;
            Node node = end;
            if (end.prev == null) {
                head = end = null;
                return node;
            }
            end.prev.next = null;
            end = end.prev;
            return node;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Node node = head;
            while (node != null) {
                sb.append("(" + node.key + ", " + node.value + ")  ");
                node = node.next;
            }
            sb.append(']');
            return sb.toString();
        }
    }

    private int capacity;
    private DoublyLinkedKVList<Integer, Integer> list;
    private Map<Integer, DoublyLinkedKVList.Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new DoublyLinkedKVList<>();
        this.map = new HashMap<>();
    }

    /*
    mark one node as newly used.
     */
    private void markUse(DoublyLinkedKVList.Node node) {
        list.moveToHead(node);
    }

    /*
    add a new node, and delete the oldest one if necessary.
     */
    private void addNewNode(int key, int value) {
        DoublyLinkedKVList.Node node = list.addToHead(key, value);
        map.put(key, node);
        if (map.size() > capacity)
            removeOldestNode();
    }

    /*
    remove the oldest node.
     */
    private void removeOldestNode() {
        DoublyLinkedKVList.Node node = list.removeEnd();
        map.remove(node.key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoublyLinkedKVList.Node node = map.get(key);
            node.value = value;
            markUse(node);
        }
        else {
            addNewNode(key, value);
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoublyLinkedKVList.Node node = map.get(key);
            markUse(node);
            System.out.println(node.value);
            return (int) node.value;
        }
        System.out.println(-1);
        return -1;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        cache.put(10,13);
        cache.put(3,17);
        cache.put(6, 11);
        cache.put(10, 15);
        cache.put(9, 10);
        cache.get(13);
        cache.put(2, 19);
        cache.get(2);
        cache.get(3);
        cache.put(5, 25);
        cache.get(8);
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        cache.get(11);
        cache.put(9, 12);
        cache.get(7);
        cache.get(5);
        cache.get(8);
        cache.get(9);
        cache.put(4, 30);
        cache.put(9, 3);
        cache.get(9);
        cache.get(10);
        cache.get(10);
        cache.put(6,14);
        cache.put(3, 1);
        cache.get(3);
        cache.put(10, 11);
        cache.get(8);
        cache.put(2,14);
        cache.get(1);
        cache.get(5);
        cache.get(4);
        cache.put(11,4);
        cache.put(12,24);
        cache.put(5,18);
        cache.get(13);
        cache.put(7, 23);
        cache.get(8);
        cache.get(12);
        cache.put(3,27);
        cache.put(2,12);
        cache.get(5);
        cache.put(2, 9);
        cache.put(13, 4);
        cache.put(8, 18);
        cache.put(1, 7);
        cache.get(6);
    }
}