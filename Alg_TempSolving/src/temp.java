import java.io.*;
import java.util.*;

public class temp {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String target = input.readLine();
        int idx = Integer.parseInt(input.readLine());
        System.out.println(target.charAt(idx - 1));
    }
}
