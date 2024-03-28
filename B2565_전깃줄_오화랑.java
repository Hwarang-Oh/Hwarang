import java.io.*;
import java.util.*;

public class B2565_전깃줄_오화랑 {
    static class Line {
        int x, y;
        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static PriorityQueue<Line> lineList = new PriorityQueue<>(new Comparator<Line>() {
        @Override
        public int compare(Line o1, Line o2) {
            int diff = Integer.compare(o1.x, o2.x);
            return diff != 0 ? diff : Integer.compare(o1.y, o2.y);
        }
    });
    static int[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int size = Integer.parseInt(input.readLine());
        lines = new int[size];
        int eachX, eachY;
        for (int i = 0 ; i < size ; i++) {
            st = new StringTokenizer(input.readLine());
            eachX = Integer.parseInt(st.nextToken());
            eachY = Integer.parseInt(st.nextToken());
            lineList.add(new Line(eachX, eachY));
        }
        int index = 0;
        while (!lineList.isEmpty()) { // 시작점을 기준으로 End 지점에 대한 수열 생성 -> 최장증가수열의 길이를 구하면 된다.
            lines[index++] = lineList.poll().y;
        }
        
    }
}

// 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때 -> 남아있는 모든 전깃줄 교차 X (최소 개수)
// 전깃줄 개수 100 이하
// 전깃줄이 A전봇대와 연결되는 위치으 번호와 B 전봇대 위치 주어짐 (500이하 자연수)
// 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.
// 잘라야하는 전깃줄의 최소개수 출력
// 입력받으면서 전깃줄의 연결 여부를 갱신한다.
// 연결이 많이 되어 있는 전깃줄을 삭제하면서, 다시 갱신 => 모두 연결여부가 0이되면 종료
// 10000개의 연산?