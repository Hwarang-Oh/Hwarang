import java.io.*;
import java.util.*;

public class T0229_오화랑 {
    static int[] made, parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(input.readLine());
        int M = Integer.parseInt(input.readLine());
        int[] numbers = new int[N];
        visited = new boolean[N];
        made = new int[M];

        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

//        Perm(0,M,numbers);
//        Comb(0, 0, M, numbers);
//        Power(0, numbers);
//        Arrays.sort(numbers);
//        do {
//            System.out.println(Arrays.toString(numbers));
//        }while(nextP(numbers));

//        Arrays.sort(numbers);
//        int[] nextCvisited = new int[N];
//        for (int i = 0 ; i < M ; i++) nextCvisited[N - M + i] = 1;
//
//        do {
//            int index = 0;
//            for (int i = 0 ; i < N ; i++) {
//                if(nextCvisited[i] == 1) { made[index++] = numbers[i]; }
//            }
//            System.out.println(Arrays.toString(made));
//        }while(nextC(nextCvisited));


    }
    public static void Perm(int cnt, int M, int[] numbers) {
        if (cnt == M) {
            System.out.println(Arrays.toString(made));
            return;
        }
        for (int i = 0 ; i < numbers.length ; i++) {
            made[cnt] = numbers[i];
            visited[i] = true;
            Perm(cnt + 1, M, numbers);
            visited[i] = false;
        }
    }
    public static void Comb(int cnt, int start, int M, int[] numbers){
        if (cnt == M) {
            System.out.println(Arrays.toString(made));
            return;
        }
        for (int i = start ; i < numbers.length ; i++) {
            made[cnt] = numbers[i];
            Comb(cnt + 1, i + 1, M, numbers);
        }
    }
    public static void Power(int cnt, int[] numbers) {
        if (cnt == numbers.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0 ; i < numbers.length ; i++) {
                if(visited[i]) temp.add(numbers[i]);
            }
            if(temp.size() > 0 ) System.out.println(temp);
            return;
        }
        visited[cnt] = true;
        Power(cnt + 1, numbers);
        visited[cnt] = false;
        Power(cnt + 1, numbers);
    }

    public static boolean nextP(int[] numbers) {
        final int size = numbers.length;

        int target = size - 1;
        while(target > 0 && numbers[target - 1] > numbers[target]) --target;
        if (target == 0) return false;

        int swapLoc = size - 1;
        while(numbers[target - 1] > numbers[swapLoc]) -- swapLoc;
        swap(numbers, target - 1, swapLoc);

        int back = size - 1;
        while(target < back) swap(numbers, target++, back--);
        return true;
    }

    public static boolean nextC(int[] numbers) {
        final int size = numbers.length;

        int target = size - 1;
        while(target > 0 && numbers[target - 1] >= numbers[target]) --target;
        if (target == 0) return false;

        int swapLoc = size - 1;
        while(numbers[target - 1] >= numbers[swapLoc]) -- swapLoc;
        swap(numbers, target - 1, swapLoc);

        int back = size - 1;
        while(target < back) swap(numbers, target++, back--);
        return true;
    }
    public static void swap(int[] arr, int num1 , int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    public static void makeSet(int num) {
        parents = new int[num + 1];
        for (int i = 1 ; i <= num ; i++) parents[i] = i;
    }
    public static int findSet(int num) {
        if (parents[num] == num) return num;
        else return parents[num] = findSet(parents[num]);
    }
    public static void union(int num1, int num2) {
        int root1 = findSet(num1);
        int root2 = findSet(num2);
        if (root1 == root2) return;
        else parents[root2] = root1;
    }
}
