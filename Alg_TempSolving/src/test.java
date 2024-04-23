import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = input.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i)))
                sb.append(Character.toLowerCase(str.charAt(i)));
            else
                sb.append(Character.toUpperCase(str.charAt(i)));
        }
        System.out.println(sb);
    }

}
