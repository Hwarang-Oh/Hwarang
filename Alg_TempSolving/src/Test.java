import java.util.*;

public class Test {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }

    public static void main(String[] args) {

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(3, 3));
        System.out.println(queue.peek());

        Pair peeked = queue.peek();
        peeked.x = 5;
        peeked.y = 5;
        System.out.println(queue.peek());
    }
}