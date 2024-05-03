import java.util.*;
import java.io.*;

/*
 * Pn = Pn-a + Pa + Naive N Case
 */

public class temp {

    static ArrayList<ArrayList<Integer>> boxList;
    static HashMap<Integer, ArrayList<ArrayList<Integer>>> memo;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int stdNum = Integer.parseInt(st.nextToken());
        int maxNum = Integer.parseInt(st.nextToken());
        int targetH = Integer.parseInt(st.nextToken());
        boxList = new ArrayList<>(stdNum + 1);
        boxList.add(new ArrayList<>());

        for (int i = 1; i <= stdNum; i++) {
            st = new StringTokenizer(input.readLine());
            boxList.add(new ArrayList<>(maxNum));
            while (st.hasMoreTokens()) {
                boxList.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int tH = 1; tH <= targetH; tH++) {
            for (int i = 1 ; i <= stdNum ; i++) {
                for (int eachH : boxList.get(i)) {
                    if (eachH == tH) {
                        memo.get(tH).add()
                    }
                }
            } 


            for (int eachStud : memo.keySet()) {
                for (int eachH : boxList.get(eachStud)) {
                    if (eachH == tH) {
                        memo.get(eachS)
                    }
                }
            }    
        }
        }

    for(

    int i = 1;i<=h/2;i++)
    {
        memo[h] = memo[i] + memo[h - i];
    }
    }}

    public static int getMemo(int num) {
        if ()
    }

}

/*
 * for (PriorityQueue<Integer> each : boxList) {
 * while (!each.isEmpty()) {
 * System.out.print(each.poll() + " ");
 * }
 * System.out.println();
 * }
 */
