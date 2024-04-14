import java.io.*;

public class B9935_문자열폭발_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String target = input.readLine();
        String bomb = input.readLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0 ; i < target.length() ; i++) {
            result.append(target.charAt(i));
            if (result.length() >= bomb.length()
                    && result.substring(result.length() - bomb.length()).equals(bomb)) {
                result.delete(result.length() - bomb.length(), result.length());
            }
        }
        if (result.length() > 0) System.out.println(result);
        else System.out.println("FRULA");
    }
}

//public class B9935_문자열폭발_오화랑 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder target = new StringBuilder(input.readLine());
//        String bomb = input.readLine();
//
//        Stack<Integer> bombPoint = new Stack<>();
//        int possCheck = target.length() - bomb.length() + 1;
//        for (int i = 0 ; i < possCheck ; i++) {
//            if (target.charAt(i) == bomb.charAt(0)) bombPoint.push(i);
//        }
//        int tempB;
//        boolean isSame;
//        while(!bombPoint.isEmpty()) {
//            tempB = bombPoint.pop();
//            isSame = true;
//            for (int p = 1 ; p < bomb.length() ; p++) {
//                if (target.charAt(tempB + p) != bomb.charAt(p)) {
//                    isSame = false;
//                    break;
//                }
//            }
//            if (isSame) target.delete(tempB, tempB + bomb.length());
//        }
//        if (target.length() > 0) System.out.println(target);
//        else System.out.println("FRULA");
//    }
//}