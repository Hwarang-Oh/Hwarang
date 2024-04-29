import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maint {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int a, b;
        while (true) {
            st = new StringTokenizer(input.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == b && a == 0)
                break;
            if (a > b)
                sb.append("Yes").append("\n");
            else
                sb.append("No").append("\n");
        }
        System.out.print(sb);
    }
}
