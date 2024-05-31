import java.io.*;
import java.util.*;

// Game은 체스판 위에 말 K 개를 놓고 시작한다. 
// 말은 1번 ~ K번까지 번호가 매겨져 있음
// 이동 방향도 미리 정해져 있음 (상하좌우)
// Turn 1 : 1번 말부터 K번 말까지 순서대로 이동 -> 말 1개가 이동할 때, 올려져 있는 말도 함께 이동됨.
// End: Turn이 진행되는 중에 말이 4개 이상 쌓이는 순간 게임 종료
// 말이 이동하는 경로는 칸에 따라서 다름.

public class B17780_새로운게임_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int size = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
    }
}
