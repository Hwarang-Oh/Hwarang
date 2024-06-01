import java.io.*;
import java.util.*;

public class B17780_새로운게임_오화랑_코드최적화_Re풀이요구 {
    static class pair {
        int each, way;

        public pair(int each, int way) {
            this.each = each;
            this.way = way;
        }
    }

    static class piece {
        int x, y, each, way;
        boolean bot;

        public piece(int x, int y, int each, int way, boolean bot) {
            this.x = x;
            this.y = y;
            this.each = each;
            this.way = way;
            this.bot = bot;
        }
    }

    static class Box {
        int color, way;
        ArrayDeque<pair> eachList;

        public Box(int color, int way, ArrayDeque<pair> eachList) {
            this.color = color;
            this.way = way;
            this.eachList = eachList;
        }
    }

    static Box[][] Map;
    static ArrayList<piece> pieceList;
    static int[][] moveList = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
    static boolean made;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int size = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Map = new Box[size + 1][size + 1];
        pieceList = new ArrayList<>(N);

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 1; j <= size; j++) {
                Map[i][j] = new Box(Integer.parseInt(st.nextToken()), 0, new ArrayDeque<>());
            }
        }

        int x, y, way;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(input.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            way = Integer.parseInt(st.nextToken());
            Map[x][y].way = way;
            Map[x][y].eachList.offer(new pair(i, way));
            pieceList.add(new piece(x, y, i, way, true));
        }

        int currX, currY, currWay;
        int nextX, nextY;
        int count = 0;
        while (!made) {
            if (count == 1001) {
                count = -1;
                break;
            }
            for (piece temp : pieceList) {
                if (!temp.bot)
                    continue;
                currX = temp.x;
                currY = temp.y;
                currWay = temp.way;
                nextX = currX + moveList[currWay - 1][0];
                nextY = currY + moveList[currWay - 1][1];
                if (nextX <= 0 || nextY <= 0 || nextX > size || nextY > size || Map[nextX][nextY].color == 2) {
                    Map[currX][currY].eachList.peek().way = temp.way = currWay = changeWay(currWay);
                    nextX += 2 * moveList[currWay - 1][0];
                    nextY += 2 * moveList[currWay - 1][1];
                    if (nextX <= 0 || nextY <= 0 || nextX > size || nextY > size || Map[nextX][nextY].color == 2) {
                        continue;
                    } else if (Map[nextX][nextY].color == 1) {
                        go(currX, currY, nextX, nextY, 1);
                    } else if (Map[nextX][nextY].color == 0) {
                        go(currX, currY, nextX, nextY, 0);
                    }
                } else if (Map[nextX][nextY].color == 1) {
                    go(currX, currY, nextX, nextY, 1);
                } else if (Map[nextX][nextY].color == 0) {
                    go(currX, currY, nextX, nextY, 0);
                }
            }
            count++;
        }
        System.out.println(count);
    }

    public static int changeWay(int currWay) {
        if (currWay == 1)
            return 2;
        else if (currWay == 2)
            return 1;
        else if (currWay == 3)
            return 4;
        else
            return 3;
    }

    public static void go(int currX, int currY, int nextX, int nextY, int mode) {
        ArrayDeque<pair> currQ = Map[currX][currY].eachList;
        ArrayDeque<pair> nextQ = Map[nextX][nextY].eachList;
        pair temp;
        if (mode == 1) {
            while (!currQ.isEmpty()) {
                temp = currQ.pollLast();
                pieceList.get(temp.each - 1).x = nextX;
                pieceList.get(temp.each - 1).y = nextY;
                pieceList.get(temp.each - 1).bot = false;
                nextQ.offer(temp);
            }
        } else {
            while (!currQ.isEmpty()) {
                temp = currQ.poll();
                pieceList.get(temp.each - 1).x = nextX;
                pieceList.get(temp.each - 1).y = nextY;
                pieceList.get(temp.each - 1).bot = false;
                nextQ.offer(temp);
            }
        }
        Map[currX][currY].way = 0;
        Map[nextX][nextY].way = nextQ.peek().way;
        pieceList.get(nextQ.peek().each - 1).bot = true;
        if (nextQ.size() >= 4)
            made = true;
    }
}
