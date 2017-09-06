package T353;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SnakeGame {

    private static int[][] D = {{0, -1}, {-1, 0}, {0, 1}, {1,0}};
    private LinkedList<int[]> snake;
    private Set<Integer> occupy;
    private int foodIndex, width, height, score;
    private int[][] foods;

    private static int d(String direction) {
        if (direction.equals("L")) return 0;
        if (direction.equals("U")) return 1;
        if (direction.equals("R")) return 2;
        return 3;
    }

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        foods = food;
        foodIndex = 0;
        snake = new LinkedList<>();
        occupy = new HashSet<>();
        snake.add(new int[] {0, 0});
        occupy.add(0);
        score = 0;
    }

    public int move(String direction) {
        if (score < 0) return score;
        int[] head = snake.getFirst();
        int[] newHead = new int[] {head[0] + D[d(direction)][0], head[1] + D[d(direction)][1]};
        int[] tail = snake.removeLast();
        occupy.remove(tail[0] * width + tail[1]);
        if (newHead[0] < 0 || newHead[0] >= height || newHead[1] < 0 || newHead[1] >= width || occupy.contains(newHead[0] * width + newHead[1])) {
            score = -1;
            return score;
        }

        snake.addFirst(newHead);
        occupy.add(newHead[0] * width + newHead[1]);
        if (foodIndex < foods.length && newHead[0] == foods[foodIndex][0] && newHead[1] == foods[foodIndex][1]) {
            snake.addLast(tail);
            occupy.add(tail[0] * width + tail[1]);
            foodIndex ++;
            return ++ score;
        }
        return score;
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(3, 2, new int[][] {{1, 2}, {0, 1}});
        System.out.println(game.move("R"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("L"));
        System.out.println(game.move("R"));


    }
}
