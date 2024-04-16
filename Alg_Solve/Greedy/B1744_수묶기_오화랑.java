import java.io.*;
import java.util.*;

public class B1744_수묶기_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(input.readLine());
        int eachNum;
        int isZero = 0;
        int isOne = 0;
        PriorityQueue<Integer> negList = new PriorityQueue<>();
        PriorityQueue<Integer> posList = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0 ; i < size ; i++) {
            eachNum = Integer.parseInt(input.readLine());
            if (eachNum < 0) negList.offer(eachNum);
            else if (eachNum == 0) isZero++;
            else if (eachNum == 1) isOne++;
            else posList.offer(eachNum);
        }

        int nSize = negList.size();
        int nSum = 0;
        while (nSize > 1) {
            nSum += negList.poll() * negList.poll();
            nSize -= 2;
        }

        int pSize = posList.size();
        int pSum = 0;
        while (pSize > 1) {
            pSum += posList.poll() * posList.poll();
            pSize -= 2;
        }
//        System.out.printf("nsum : %d psum : %d nsize : %d psize : %d isZero : %d isOne : %d%n",
//                nSum, pSum, nSize, pSize, isZero, isOne);


        if (nSize == 1) {
            if (isZero == 0) nSum += negList.poll();
        }
        if (pSize == 1) {
            pSum += posList.poll();
        }
        pSum += isOne;
        System.out.println(nSum + pSum);
    }
}
// 왜 같은 Greedy로 풀었는데, 속도가 상대적으로 느릴까?? => 최적화 요구

// 수열의 합을 구하려고 함. -> 두 수를 묶어서 곱할 수 있다.
// 수열의 크기는 50보다 작은 자연수 ( 1 ~ 50 )
// 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다. => 순서에 상관 X -> 어디서든 정렬 가능
// 수열이 주어졌을 때, 각 수를 적절하게 묶었을 때 합이 최대가 되게 하는 Programm 작성
// 정답은 2^31보다 작다
// -1 2 1 3
// -1 1 2 3 => 6
// -1 0 1 => 1
// 1 1 => 2
// 0 1 2 3 4 5 => 0 + 1 + 6 + 20 => 27
// 특수 기능을 하는 정수 -1
// 특수 기능을 하는 정수 1
// 특수 기능을 하는 정수 0
