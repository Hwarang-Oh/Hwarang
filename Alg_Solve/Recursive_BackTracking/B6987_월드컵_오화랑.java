import java.io.*;
import java.util.*;

public class B6987_월드컵_오화랑 {
    static int[][] resultE = new int[6][3]; // 기자의 예측 정보
    static int[][] eachEstimated = new int[6][5];
    // 각 국가의 예측 정보(승, 무, 패)를 세분화해서 나타낸 것
    // 승 : 1 무 : 0, 패 : -1 -> {4, 0, 1} => {1, 1, 1, 1, -1} (승 4개, 패 1개)
    static boolean[][] eachVisited = new boolean[6][5];
    // 각 국가의 예측 정보의 예측치에 접근해서 사용했는가?
    static int count;
    // 해당 기자 정보의 예측이 가능한 가짓수는 얼마나 되는가?

    static boolean canHappen;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int testCase = 0 ; testCase < 4 ; testCase++) { // 조별 리그의 경기의 예측치는 4개 입력된다.
            st = new StringTokenizer(input.readLine());
            canHappen = false; // 해당 경우는 발생할 수 있는가?
            resultE = new int[6][3]; // 예측 정보 초기화
            eachEstimated = new int[6][5]; // 세부 예측 정보 초기화
            eachVisited = new boolean[6][5]; // 세부 에측 정보 접근 초기화
            boolean havaToCalculate = true; // 해당 경기를 세부적으로 계산해야 판단이 가능한가?


            for (int i = 0; i < 6; i++) {
                resultE[i][0] = Integer.parseInt(st.nextToken());
                resultE[i][1] = Integer.parseInt(st.nextToken());
                resultE[i][2] = Integer.parseInt(st.nextToken());

                if (resultE[i][0] + resultE[i][1] + resultE[i][2] != 5) {
                    havaToCalculate = false;
                    break;
                }
                // 특정 국가의 승 / 무 / 패의 합이 5가 아니면, 해당 경기는 계산할 필요가 없다.
                // 또한 승 / 무 / 패의 합이 5보다 크면, 위에 있는 배열들에 대한 ArrayOfIndex Error 발생 (RunTime)

                int index = 0;
                for (int w = 0; w < resultE[i][0]; w++) eachEstimated[i][index++] = 1;
                for (int d = 0; d < resultE[i][1]; d++) eachEstimated[i][index++] = 0;
                for (int l = 0; l < resultE[i][2]; l++) eachEstimated[i][index++] = -1;
            }

            if (havaToCalculate) {
                eachPlayerCheck(0,0);
                if (canHappen) System.out.printf("%d ", 1);
                else System.out.printf("%d ", 0);
            }
            else System.out.printf("%d ", 0);
        }
    }
    public static void eachPlayerCheck (int eachPlayer, int eachMatch) {
        if (eachPlayer == 6) { canHappen = true; return; }
        if (eachMatch == 5 - eachPlayer) {
            eachPlayerCheck(eachPlayer + 1, 0);
            return;
        }

        boolean canUpdate;
        for (int i = 0 ; i < 5 ; i++) {
            if (canHappen) return; // 이미 canMake를 도달했다면 리턴

            canUpdate = false; // 1. 해당 Player의 예측치를 반영할 수 없다고 가정
            if (eachVisited[eachPlayer][i]) continue; // 예측치가 이미 사용되었음 -> 반영할 수 없으므로 continue;
            for (int j = 0 ; j < 5 ; j++) {
                if (eachEstimated[eachPlayer + eachMatch + 1][j] == -eachEstimated[eachPlayer][i] && !eachVisited[eachPlayer + eachMatch + 1][j]) {
                    // 상대방도 해당 예측치의 반대값을 반영할 수 있다면 ( 승 -> 패, 무 -> 무, 패 -> 승  + 반대 예측치 사용 X ) => 사용 가능
                    eachVisited[eachPlayer + eachMatch + 1][j] = true; // 상대방은 반대 예측치를 사용했다는 것을 반영
                    canUpdate = true; // 동시에 예측치를 반영할 수 있으므로, 현재 Player의 예측치를 사용한다.
                    break;
                }
            }

            if (canUpdate) { // 반영할 수 있다면, 바꿔주고 해당 예측치를 사용했다고 체크해준다.
                eachVisited[eachPlayer][i] = true;
                eachPlayerCheck(eachPlayer, eachMatch + 1); // 다음 경기로 넘어간다.
            }
            else continue; // 해당 예측치를 반영할 수 없으므로, 다른 예측치를 사용하러 간다.

            // 2 - 2. 재귀를 마치고 돌아옴 -> 사용한 예측치를 사용하지 않았다고 반영해야 함.
            eachVisited[eachPlayer][i] = false; // 해당 예측치를 사용하지 않았다고 변경
            for (int j = 0 ; j < 5 ; j++) {
                if (eachEstimated[eachPlayer + eachMatch + 1][j] == -eachEstimated[eachPlayer][i] && eachVisited[eachPlayer + eachMatch + 1][j]) {
                    eachVisited[eachPlayer + eachMatch + 1][j] = false; // 상대방도 예측치를 사용하지 않았다고 변경.
                    break;
                }
            }
        }
    }
}

// 4개의 조별리그의 예측치만 들어온다
