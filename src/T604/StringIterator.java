package T604;

public class StringIterator {

    private String compressed;
    private int index;
    private char cur;
    private int left;

    public StringIterator(String compressedString) {
        compressed = compressedString;
        index = 0;
        left = 0;
    }

    private void parseNext() {
        cur = compressed.charAt(index);
        char c = compressed.charAt(++ index);
        left = 0;
        while (c >= '0' && c <= '9') {
            left = left * 10 + c - '0';
            index ++;
            if (index == compressed.length()) break;
            c = compressed.charAt(index);
        }
    }

    public char next() {
        if (left > 0) {
            left --;
            return cur;
        }
        if (index == compressed.length()) return ' ';
        parseNext();
        left --;
        return cur;
    }

    public boolean hasNext() {
        if (left > 0 || index < compressed.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }
}
