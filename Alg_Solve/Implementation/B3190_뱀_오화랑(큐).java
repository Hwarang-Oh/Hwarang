import java.io.*;
import java.util.*;

public class B3190_뱀_HR {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> moveLog = new ArrayDeque<>();
        Queue<Integer> moveList = new ArrayDeque<>();
        int size = Integer.parseInt(input.readLine());
        int appleNum = Integer.parseInt(input.readLine());
        int[][] map = new int [size + 1][size + 1];
        int moveCnt; int maxTime = 0;

        for (int i = 0 ; i < appleNum ; i++) {
            st = new StringTokenizer(input.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]
                    = 1;
        }

        moveCnt = Integer.parseInt(input.readLine());
        for (int i = 0 ; i < moveCnt ; i++) {
            st = new StringTokenizer(input.readLine());

            if (i == moveCnt - 1) {
                maxTime = Integer.parseInt(st.nextToken());
                moveList.offer(maxTime);
            } else moveList.offer(Integer.parseInt(st.nextToken()));

            switch (st.nextToken()) {
                case "L" : moveList.offer(-1); break;
                case "D" : moveList.offer(1);
            }
        }
        System.out.println(Arrays.deepToString(map));
        System.out.println(moveList);


        for (int t = 1 ; t <= maxTime ; t++) {
            System.out.println(t);
        }


    }
}

// 뱀의 시작 위치 0,0 -> 뱀 길이 1 ( 칸을 차지하는 수 -> 길이 )
// 뱀의 이동 -> 머리를 다음 칸에 위치시킴
// 사과가 있다면, 꼬리를 줄이지 않음 ( 뱀의 차지칸 + 1 => 길이 + 1)
// 사과가 없다면, 꼬리를 줄임 ( 뱀의 차지칸 - 1 => 길이 - 1)
// 벽과 자기 자신과 몸을 부딪히면 게임 종료
// 뱀은 매 초마다 이동 => 게임 종료 시점을 구하여라