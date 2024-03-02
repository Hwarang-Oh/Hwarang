import java.io.*;
import java.util.*;

public class S2383_점심식사시간_오화랑 {
    static class stair {
        int sRow, sCol, goTime;
        int goingNum, haveToGo, haveGone;
        public stair(int sRow, int sCol, int goTime) {
            this.sRow = sRow;
            this.sCol = sCol;
            this.goTime = goTime;
            goingNum = haveToGo = haveGone = 0;
        }
    }
    static class person {
        int pRow, pCol;
        int timeToS, goDownTime, waitCount;
        boolean isDone;
        public person(int pRow, int pCol) {
            this.pRow = pRow;
            this.pCol = pCol;
            this.isDone = false;
        }
        public void getTime(int sRow, int sCol) {
            timeToS = Math.abs(pRow - sRow) + Math.abs(pCol -sCol);
        }
    }
    static stair[] stairs = new stair[2];
    static ArrayList<person> people = new ArrayList<>();
    static int minTime = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int testCase = Integer.parseInt(input.readLine());

        int size, num, sIndex;
        for (int t = 1 ; t <= testCase ; t++) {
            size = Integer.parseInt(input.readLine());
            sIndex = 0;
            for (int i = 0 ; i < size ; i++) {
                st = new StringTokenizer(input.readLine());
                for (int j = 0 ; j < size ; j++) {
                    num = Integer.parseInt(st.nextToken());
                    if (num > 1) stairs[sIndex++] = new stair(i,j,num);
                    else if (num == 1) people.add(new person(i,j));
                }
            }
            boolean[] selected = new boolean[people.size()]; // 여러개 testCase에서는 초기화 필수!!
            selectStair(0,selected,people);
            System.out.println(minTime);
            minTime = Integer.MAX_VALUE;
            people = new ArrayList<>();
        }
    }
    public static void selectStair(int cnt, boolean[] selected, ArrayList<person> people){ // 먼저 사람들은 계단을 선택한다.
        if (cnt == selected.length) { // 부분집합 Case 완성에 도달하면
            ArrayList<person> stair1Go = new ArrayList<>(); // 계단 1로 이동
            ArrayList<person> stair2Go = new ArrayList<>(); // 계단 2로 이동
            for (int i = 0 ; i < selected.length ; i++) {
                if (selected[i] == true) { // 만약 계단 1로 선택되었다면
                    people.get(i).getTime(stairs[0].sRow, stairs[0].sCol); // 해당 계단을 향한 경로값 계산
                    people.get(i).isDone = false; // 도착 X 상태로 설정
                    stair1Go.add(people.get(i));
                }
                else {
                    people.get(i).getTime(stairs[1].sRow, stairs[1].sCol);
                    people.get(i).isDone = false;
                    stair2Go.add(people.get(i));
                }
            }
            minTime = Math.min(minTime, countTime(stair1Go, stair2Go));
            return;
        }
        selected[cnt] = true;
        selectStair(cnt + 1, selected, people);
        selected[cnt] = false;
        selectStair(cnt + 1, selected, people);
    }

    public static int countTime(ArrayList<person> stair1Go, ArrayList<person> stair2Go){ // 선택된 조합으로 시간을 계산한다.
        stairs[0].haveToGo = stair1Go.size(); stairs[0].haveGone = 0;
        stairs[1].haveToGo = stair2Go.size(); stairs[1].haveGone = 0;
        int time = 0;
        while (true) {
            for (person p : stair1Go) {
                if (stairs[0].haveToGo == stairs[0].haveGone) break;
                if (p.isDone) continue;
                if (p.timeToS > 0) p.timeToS--;
                else if (p.timeToS == 0) p.waitCount++;
                else {
                    if (p.goDownTime++ == stairs[0].goTime) { // 계단 이동시간 + 1 == 계단 경로 -> 도착한 경우
                        stairs[0].goingNum--; // 계단 이용자 --
                        stairs[0].haveGone++; // 도착한 사람 ++
                        p.isDone = true; // 해당 사람은 완료
                        p.waitCount = 0;
                    }
                }
            }
            for (person p : stair1Go) {
                if (stairs[0].haveToGo == stairs[0].haveGone) break;
                if (p.isDone) continue;
                if (p.timeToS == 0 && p.waitCount > 1) {
                    if (stairs[0].goingNum < 3) { // 현재 계단을 3명 이하로 이용 중이면 -> 내가 이동할 준비 -> p.timeToS = -1;
                        p.timeToS--; // -1
                        p.goDownTime = 0; // 현재 계단 이동시간 0
                        stairs[0].goingNum++; // 계단 이용자 + 1
                    }
                }
            }

            for (person p : stair2Go) {
                if (stairs[1].haveToGo == stairs[1].haveGone) break;
                if (p.isDone) continue;
                if (p.timeToS > 0) p.timeToS--;
                else if (p.timeToS == 0) p.waitCount++;
                else {
                    if (p.goDownTime++ == stairs[1].goTime) { // 계단 이동시간 + 1 == 계단 경로 -> 도착한 경우
                        stairs[1].goingNum--; // 계단 이용자 --
                        stairs[1].haveGone++; // 도착한 사람 ++
                        p.isDone = true; // 해당 사람은 완료
                        p.waitCount = 0;
                    }
                }
            }
            for (person p : stair2Go) {
                if (stairs[1].haveToGo == stairs[1].haveGone) break;
                if (p.isDone) continue;
                if (p.timeToS == 0 && p.waitCount > 1) {
                    if (stairs[1].goingNum < 3) { // 현재 계단을 3명 이하로 이용 중이면 -> 내가 이동할 준비 -> p.timeToS = -1;
                        p.timeToS--; // -1
                        p.goDownTime = 0; // 현재 계단 이동시간 0
                        stairs[1].goingNum++; // 계단 이용자 + 1
                    }
                }
            }

            if (stairs[0].haveToGo == stairs[0].haveGone && stairs[1].haveToGo == stairs[1].haveGone) break;
            time++;
        }
        return time;
    }
}
