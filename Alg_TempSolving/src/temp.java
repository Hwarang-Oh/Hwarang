import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class temp {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(input.readLine());
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
    }
}
