import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] cnt = new int[10];
        for (int i = 1; i <= a; i++) {
            String temp = String.valueOf(i);

            for (int t = 0; t < temp.length(); t++) {
                cnt[Character.getNumericValue(temp.charAt(t))]++;
            }
        }
        System.out.println(Arrays.toString(cnt));
    }
}
