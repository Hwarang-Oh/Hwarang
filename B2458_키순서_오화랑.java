import java.io.*;
import java.util.*;

public class B2458_키순서_오화랑 {

    static class student {
        Queue<Integer> winMemo = new ArrayDeque<>();
        Queue<Integer> loseMemo = new ArrayDeque<>();
    }
    static student[] studList;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int sNum = Integer.parseInt(st.nextToken());
        int optNum = Integer.parseInt(st.nextToken());
        studList = new student[sNum + 1];
        for (int i = 1 ; i <= sNum ; i++) studList[i] = new student();

        int s1, s2;
        for (int i = 1 ; i <= optNum ; i++) {
            st = new StringTokenizer(input.readLine());
            s1 = Integer.parseInt(st.nextToken());
            s2 = Integer.parseInt(st.nextToken());
            studList[s1].loseMemo.offer(s2);
            studList[s2].winMemo.offer(s1);
            reflectWinRank(studList[s2], studList[s1]);
            reflectLoseRank(studList[s2], studList[s1]);
        }
//        for (int i = 1; i <= sNum ; i++) {
//            HashSet<Integer> set = new HashSet<>();
//            while(!studList[i].winMemo.isEmpty()) set.add(studList[i].winMemo.poll());
//            while(!studList[i].loseMemo.isEmpty()) set.add(studList[i].loseMemo.poll());
//            System.out.println(set.size());
//        }



        int i = 0;
        for (student each : studList) {
            if (i == 0) { i++; continue;}
            System.out.println(i + "번째 학생 win");
            while(!each.winMemo.isEmpty()) System.out.print(each.winMemo.poll());
            System.out.println();
            System.out.println(i++ + "번째 학생 lose");
            while(!each.loseMemo.isEmpty()) System.out.print(each.loseMemo.poll());
            System.out.println();
        }



    }
    public static void reflectWinRank(student sWin, student sLose) {
        int qSize = sLose.winMemo.size();
        int tempNum;
        while (qSize > 0) {
            tempNum = sLose.winMemo.poll();
            sWin.winMemo.offer(tempNum);
            sLose.winMemo.offer(tempNum);
            qSize--;
        }
    }
    public static void reflectLoseRank(student sWin, student sLose) {
        int qSize = sWin.loseMemo.size();
        int tempNum;
        while (qSize > 0) {
            tempNum = sWin.loseMemo.poll();
            sLose.loseMemo.offer(tempNum);
            sWin.loseMemo.offer(tempNum);
            qSize--;
        }
    }
}
