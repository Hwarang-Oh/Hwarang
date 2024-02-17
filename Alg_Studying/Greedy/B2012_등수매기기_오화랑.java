import java.io.*;
import java.util.Arrays;
import java.util.Random;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

// BufferedReader 사용
//        Random rand = new Random();
//        int[] perdictedRank_list = new int[500_000];
//        for (int stud = 0 ; stud < 500_000 ; stud++)
//            perdictedRank_list[stud] = rand.nextInt(500_000) + 1;

import java.io.*;
import java.util.Arrays;

public class BOJ_Greedy_2012_HR {
    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        int numStud = Integer.parseInt(input.readLine());
//        int[] predictedRank_list = new int[numStud];
//        for (int stud = 0 ; stud < numStud ; stud++)
//            predictedRank_list[stud] = Integer.parseInt(input.readLine());
        Random rand = new Random();
        int[] predictedRank_list = new int[10];
        for (int stud = 0 ; stud < 10 ; stud++)
            predictedRank_list[stud] = rand.nextInt(10) + 1;
        Arrays.sort(predictedRank_list); // void형
        long maxDiff = 0;
        int currRank = 1;
        for (int predictedRank : predictedRank_list) {
            maxDiff += Math.abs(predictedRank - currRank);
            currRank++;
        }
        System.out.println(maxDiff);
    }
}

/*
5
1
5
3
1
2
 */