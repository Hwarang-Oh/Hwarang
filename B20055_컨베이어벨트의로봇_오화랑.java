import java.io.*;
import java.util.*;

public class B20055_컨베이어벨트의로봇_오화랑 {
    static class belt {
        int location, howMuch, robotNum;
        boolean isOn;
        public belt(int location, int howMuch) {
            this.location = location;
            this.howMuch = howMuch;
            this.robotNum = -1;
            this.isOn = false;
        }
    }
    static belt[] conBelt;
    static ArrayList<Integer> rList = new ArrayList<>();
    static int kCount;
    static boolean canMove = true;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int cSize = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        conBelt = new belt[2 * cSize];
        st = new StringTokenizer(input.readLine());
        for (int i = 0 ; i < 2 * cSize ; i++) conBelt[i] = new belt(i, Integer.parseInt(st.nextToken()));
        int stage = 0;
        while (true) {
            move(cSize, K, stage);
            if (!canMove) break;
            stage++;
            System.out.println(canMove);
        }
        System.out.println(stage);
    }
    public static void move(int cSize, int K, int stage) {
        // step 1 : Belt가 움직인다.
        for (belt eachB : conBelt) {
            int nextBelt = eachB.location + 1;
            if (nextBelt == 2 * cSize) nextBelt = 0;
            if (nextBelt == cSize - 1 && eachB.isOn) {
                eachB.isOn = false;
                rList.set(eachB.robotNum, -1);
                eachB.robotNum = -1;
            }
            eachB.location = nextBelt;
            if (eachB.isOn) rList.set(eachB.robotNum, nextBelt);
        }
        // step 2 : 로봇이 움직인다.
        for (int i = 0 ; i < rList.size() ; i++) {
            if (rList.get(i) == -1) continue;
            int nextBelt = rList.get(i) + 1;

            if (conBelt[nextBelt].howMuch == 0 || conBelt[nextBelt].isOn) continue;
            if (nextBelt == cSize - 1 && conBelt[nextBelt].howMuch > 0) {
                conBelt[nextBelt].howMuch--;
                if (conBelt[nextBelt].howMuch == 0) kCount++;
                rList.set(i, -1);
            }
            else {
                conBelt[nextBelt].howMuch--;
                conBelt[nextBelt].isOn = true;
                conBelt[nextBelt].robotNum = i;
                if (conBelt[nextBelt].howMuch == 0) kCount++;
                rList.set(i, nextBelt);
            }
            conBelt[rList.get(i)].robotNum = -1;
            conBelt[rList.get(i)].isOn = false;
        }

        // step 3 : 올리는 위치에 로봇이 추가된다.
        for (int i = 0 ; i < 2 * cSize ; i++) {
            if (conBelt[i].location == 0 && conBelt[i].howMuch > 0) {
                rList.add(0);
                conBelt[i].robotNum = stage;
                conBelt[i].howMuch--;
                conBelt[i].isOn = true;
                if (conBelt[i].howMuch == 0) kCount++;
                break;
            }
        }
        if (kCount == K) canMove = false;
    }
}
