import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maint {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                case 1: {
                    sb.append(1 - Integer.parseInt(st.nextToken())).append(" ");
                    break;
                }
                case 2:
                case 3:
                case 4: {
                    sb.append(2 - Integer.parseInt(st.nextToken())).append(" ");
                    break;
                }
                case 5:
                    sb.append(8 - Integer.parseInt(st.nextToken()));
            }
        }
        System.out.println(sb);
    }

}
