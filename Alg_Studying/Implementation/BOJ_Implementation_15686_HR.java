import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ_Implementation_15686_HR {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(input.readLine());

        int value;
        int size = Integer.parseInt(ST.nextToken());
        int max_chicken = Integer.parseInt(ST.nextToken());
        int [] tempList = new int [2];
        ArrayList<int []> houseList = new ArrayList<>();
        ArrayList<int []> chickenList = new ArrayList<>();

        for (int i = 0 ; i < size ; i++) {
            ST = new StringTokenizer(input.readLine());
            for (int j = 0 ; j < size ; j++) {
                value = Integer.parseInt(ST.nextToken());
                if (value == 1) {
                    tempList[0] = i;
                    tempList[1] = j;
                    houseList.add(tempList);
                }
                else if (value == 2){
                    tempList[0] = i;
                    tempList[1] = j;
                    chickenList.add(tempList);
                }
            }
        }
        for (int[] arr : houseList) {
            for (int i = 0 ; i < 2 ; i++){
                System.out.printf("[%d %d]",arr[0],arr[1]);
            }
        }
        for (int[] arr : chickenList) {
            for (int i = 0 ; i < 2 ; i++){
                System.out.printf("[%d %d]",arr[0],arr[1]);
            }
        }


//        for (int i = 0 ; i < size ; i++) {
//            ST = new StringTokenizer(input.readLine());
//            tempList.clear();
//            for (int j = 0 ; j < size ; j++) {
//                if (Integer.parseInt(ST.nextToken()) == 1){
//                    tempList.add(i);
//                    tempList.add(j);
//                    houseList.add(tempList);
//                }
//                else if (Integer.parseInt(ST.nextToken()) == 2){
//                    tempList.add(i);
//                    tempList.add(j);
//                    chickenList.add(tempList);
//                }
//            }

//                if (ST.nextToken().equals("1")) {
//                    temp[0] = i;
//                    temp[1] = j;
//                    houseList.add(temp);
//                }

//                else if (ST.nextToken().equals("2")) {
//                    temp[0] = i;
////                    temp[1] = j;
////                    chickenList.add(temp);
//        }
//        System.out.println(houseList.toString());
//        System.out.println(chickenList.toString());
    }
}


// 2 중심으로 Finding?
// 1 중심으로 Finding?
//        System.out.println(houseList.toString());
//        System.out.println(chickenList.toString());