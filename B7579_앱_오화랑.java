import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B7579_앱_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int pNum = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] memo = new int[target + 1];


        StringTokenizer stM = new StringTokenizer(input.readLine());
        StringTokenizer stC = new StringTokenizer(input.readLine());
        int eachM, eachC;
        for (int i = 0 ; i < pNum ; i++) {
            eachM = Integer.parseInt(stM.nextToken());
            eachC = Integer.parseInt(stC.nextToken());

        }
    }
}
