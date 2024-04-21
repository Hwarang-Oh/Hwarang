import java.io.*;
import java.util.*;

public class B1629_곱셈_오화랑_실패 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        long number = Long.parseLong(st.nextToken());
        int loop = Integer.parseInt(st.nextToken());
        int modNum = Integer.parseInt(st.nextToken());
        ArrayList<Long> beforeList = new ArrayList<>();
        ArrayList<Long> modList = new ArrayList<>();

        int used = 0;
        long target = number;
        while (target < modNum) { // not in modular loop yet
            beforeList.add(target % modNum);
            target *= number;
            used++;
        }
        System.out.println(beforeList);
        System.out.println(number);
        System.out.println(used);

        if (loop <= used) {
            System.out.println(beforeList.get(loop - 1));
        }

        else {
            modList.add(target % modNum); // Base Condition
            while (true) {
                target *= number;
                target %= modNum;
                if (target == 0 || target == modList.get(0))
                    break;
                modList.add(target);
            }
            System.out.println(modList);

            if (target == 0)
                System.out.println(target);
            else {
                loop -= used;
                loop = loop % modList.size();
                System.out.println(modList.get(loop - 1));
            }
        }
    }
}

// Smth about Modular Process
