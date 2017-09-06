package T284;

import java.util.Arrays;
import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private boolean isLastPeek;
    private boolean lastFlag;
    private Integer lastEle;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        isLastPeek = false;
        lastEle = null;
        lastFlag = true;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (isLastPeek) return lastEle;
        isLastPeek = true;
        lastEle = iterator.next();
        return lastEle;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    @Override
    public Integer next() {
        if (isLastPeek) {
            isLastPeek = false;
            return lastEle;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (isLastPeek)
            return lastFlag;
        lastFlag = iterator.hasNext();
        return lastFlag;
    }

    public static void main(String[] args) {
        PeekingIterator iterator = new PeekingIterator(Arrays.asList(1,2,3,4,5).iterator());
        System.out.println(iterator.peek());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.peek());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.peek());
        System.out.println(iterator.next());
        System.out.println(iterator.peek());
        System.out.println(iterator.peek());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.peek());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());

    }

}
