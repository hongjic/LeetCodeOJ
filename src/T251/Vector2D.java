package T251;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

    private List<List<Integer>> vec2d;
    private int i, j;

    public void restart() {
        i = 0; j = 0;
        while (i < vec2d.size() && j == vec2d.get(i).size()) {
            i ++; j = 0;
        }
    }

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        restart();
    }

    @Override
    public Integer next() {
        Integer ele = vec2d.get(i).get(j);
        j ++;
        while (i < vec2d.size() && j == vec2d.get(i).size()) {
            i ++; j = 0;
        }
        return ele;
    }

    @Override
    public boolean hasNext() {
        if (i < vec2d.size() && j < vec2d.get(i).size())
            return true;
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(Arrays.asList(), Arrays.asList(2,3,4), Arrays.asList());
        Vector2D v2d = new Vector2D(arr);
        while (v2d.hasNext())
            System.out.println(v2d.next());
    }
}
