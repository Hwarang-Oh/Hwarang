import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] target = input.readLine().toCharArray();
        char[] bomb = input.readLine().toCharArray();
        boolean[] check = new boolean[target.length];

        int currLen = target.length;
        int nextLen = 0;
        int temp;
        boolean isSame;
        while (currLen > nextLen) {
            nextLen = currLen;
            for (int i = 0; i < target.length; i++) {
                if (target[i] == bomb[0]) {
                    isSame = true;
                    temp = 0;
                    for (int j = 0; j < bomb.length; j++) {
                        if (target[i + j] != bomb[j]) {
                            isSame = false;
                            break;
                        }
                        check[i + j] = true;
                        temp++;
                    }
                    if (!isSame) {
                        for (int j = 0; j < temp; j++) check[i + j] = false;
                    }
                    else nextLen -= temp;
                }
            }
        }
        if (target.length == 0) System.out.println("FRULA");
        else {
            for (int i = 0 ; i < target.length ; i++) sb.append(target[i]);
            System.out.println(sb);
        }
    }
}
// 어떻게 Memory 초과가 되지 않고 해결할 수 있을까?
/*
char[] Array를 복사하는 Method로 풀면 안됨.
=> 복사하지 않고 문자열을 폭발시킬 수 있는가?
=> Queue를 2개 이용하는 방법? => 너무 복잡한데..

 */



/*
Memory 초과된 답안 -> char[] Array가 너무 많이 선언됨
public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] target = input.readLine().toCharArray();
        char[] bomb = input.readLine().toCharArray();
        char[] nextTarget;
        boolean[] check;

        int currLen = target.length;
        int nextLen = 0;
        int temp, idx;
        boolean isSame;
        while (currLen > nextLen) {
            check = new boolean[target.length];
            currLen = nextLen = target.length;
            for (int i = 0; i < target.length; i++) {
                if (target[i] == bomb[0]) {
                    isSame = true;
                    temp = 0;
                    for (int j = 0; j < bomb.length; j++) {
                        if (target[i + j] != bomb[j]) {
                            isSame = false;
                            break;
                        }
                        check[i + j] = true;
                        temp++;
                    }
                    if (!isSame) {
                        for (int j = 0; j < temp; j++) check[i + j] = false;
                    }
                    else nextLen -= temp;
                }
            }
            nextTarget = new char[nextLen];
            idx = 0;
            for (int j = 0; j < target.length; j++) {
                if (!check[j]) nextTarget[idx++] = target[j];
            }
            target = nextTarget;
        }
        if (target.length == 0) System.out.println("FRULA");
        else {
            for (int i = 0 ; i < target.length ; i++) sb.append(target[i]);
            System.out.println(sb);
        }
    }
 */