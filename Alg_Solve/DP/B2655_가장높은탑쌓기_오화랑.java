import java.io.*;
import java.util.*;

public class Main2 {
    static class comp {
        int B, W, H, N;

        public comp(int b, int w, int h, int n) {
            B = b;
            W = w;
            H = h;
            N = n;
        }
    }

    static int maxHeight;
    static int maxHeightKey;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int num = Integer.parseInt(input.readLine());
        ArrayList<comp> compList = new ArrayList<>(num);
        HashMap<Integer, ArrayList<Integer>> compMemo = new HashMap<>(num + 1);
        HashMap<Integer, Integer> heightMemo = new HashMap<>(num + 1);
        compMemo.put(0, new ArrayList<>());
        heightMemo.put(0, 0);
        int b, w, h;
        for (int i = 1; i <= num; i++) {
            st = new StringTokenizer(input.readLine());
            b = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            compList.add(new comp(b, w, h, i));
        }
        compList.sort((o1, o2) -> Integer.compare(o1.B, o2.B));
        int currKey, currH, currMax, currMaxKey;
        for (int i = 0; i < num; i++) {
            currKey = compList.get(i).W;
            currH = compList.get(i).H;
            compMemo.put(currKey, new ArrayList<>());
            heightMemo.put(currKey, currH);
            currMax = 0;
            currMaxKey = 0;
            for (int eachKey : heightMemo.keySet()) {
                if (eachKey < compList.get(i).W) {
                    if (heightMemo.get(eachKey) + currH > currMax) {
                        currMax = heightMemo.get(eachKey) + currH;
                        currMaxKey = eachKey;
                    }
                }
            }
            heightMemo.put(currKey, currMax);
            for (int eachNum : compMemo.get(currMaxKey)) {
                compMemo.get(currKey).add(eachNum);
            }
            compMemo.get(currKey).add(compList.get(i).N);
            if (currMax > maxHeight) {
                maxHeight = currMax;
                maxHeightKey = currKey;
            }
        }
        int used = compMemo.get(maxHeightKey).size();
        sb.append(used).append("\n");
        for (int each : compMemo.get(maxHeightKey))
            sb.append(each).append("\n");
        System.out.print(sb);
    }
}

/*
 *
 * 5
 * 25 3 4
 * 4 4 6
 * 9 2 3
 * 16 2 5
 * 1 5 2
 * 
 * ( 1차 정렬 )
 * B W H N
 * 25 4 3, 1
 * 16 5 2, 4
 * 9 3 2, 3
 * 4 6 4, 2
 * 1 2 5, 5 =>
 * 1. 밑면 순으로 내림차순 정렬 -> 무게만 고려해서 처리를 해주면 된다.
 * 2. 어떻게 하면, 무게를 고려해서 최대 높이를 달성할까?
 * W H N
 * 4 3 1
 * 5 2 4
 * 3 2 3
 * 6 4 2
 * 2 5 5
 * =>
 */