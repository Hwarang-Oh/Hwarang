import java.io.*;

public class PJS_BasicLv4 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String first = "갑을병정무기경신임계";
        String second = "자축인묘진사오미신유술해";
        int digit_1, digit_10, tempIndex, standDiff;
        char tempWord;

        while (true) {
            System.out.print("60갑자를 입력하세요 : ");
            String gabja = input.readLine();
            if (gabja.equals("종료")){
                System.out.println("프로그램이 종료됩니다.");
                return;
            }
            // 나머지를 이용한 갑자정보를 구성
            // 갑자년 -> 나머지 0, 갑술년 -> 나머지 10, 갑신년 -> 나머지 20, 갑오년 -> 나머지 30 ...
            // 을축년 -> 나머지 1, 을해년 -> 나머지 11, 을유년 -> 나머지 21, 을미년 -> 나머지 31 ...
            digit_1 = tempIndex = first.indexOf(gabja.charAt(0));
            digit_10 = 0;
            if (digit_1 == -1) {
                System.out.println("잘못된 60갑자!");
                continue;
            }
            while (digit_10 < 6) {
                tempWord = second.charAt(tempIndex);
                if (tempWord == gabja.charAt(1)){
                    break;
                }
                else {
                    digit_10++;
                    tempIndex -= 2;
                }
                if (tempIndex == -1) tempIndex = 11;
                if (tempIndex == -2) tempIndex = 10;
            }
            if (digit_10 >= 6) {
                System.out.println("잘못된 60갑자!");
                continue;
            }
            standDiff = (digit_10 * 10) + digit_1;

            // 1800 ~ 2100 Year - (1444 원년) => 60으로 나눈 나머지와 갑자정보를 일치시키기
            for (int start = 1800 ; start <= 2100 ; start++){
                if ((start - 1444) % 60  == standDiff ) {
                    System.out.print(start + " ");
                }
            }
            System.out.println();
        }
    }
}
