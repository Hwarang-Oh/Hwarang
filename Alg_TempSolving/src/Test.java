import java.io.*;
import java.util.*;

public class Test {
    static int[] made, parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(1);
        tree.add(3);
        tree.add(5);
        System.out.println(tree.size());
        tree.add(7);
        System.out.println(tree.size());
        tree.higher(4);
        System.out.println(tree.size());
    }
}