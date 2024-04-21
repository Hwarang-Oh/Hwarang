import java.io.*;
import java.util.*;

public class B1629_곱셈_오화랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        long target = Long.parseLong(st.nextToken());
        int loop = Integer.parseInt(st.nextToken());
        int modNum = Integer.parseInt(st.nextToken());
        ArrayList<Long> beforeList = new ArrayList<>();
        ArrayList<Long> modList = new ArrayList<>();

        int used = 0;
        while (target < modNum) { // not in modular loop yet
            beforeList.add(target % modNum);
            target *= target;
            used++;
        }
        if (loop < used) {
            System.out.println();
        }
        else {



        modList.add(target % modNum); // Base Condition
        while (true) {
            target *= target;
            target = target % modNum;
            if (target == 0 || target == modList.get(0)) break;
            modList.add(target);
            System.out.println(target);
        }
        System.out.println(target);

        if (target == 0)
            System.out.println(target);
        else {
            loop = loop % modList.size();
            System.out.println(modList.get(loop));
        }
    }
}

// Smth about Modular Process
