import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2448_별찍기11_오화랑 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    }
}

// 규칙을 유추한 뒤에 별을 찍자
// N은 항상 3 * 2^k (k : 0 ~ 10) => 3, 6, 12, 24, 48, 96, 192, 384, 768, 1536, 3072
/*
 * 3 : 2배 => 2개
 * 6 : 동결 => 2개
 * 9 : 2배 => 4개
 * 
 * 12 : 2개
 * 15 : 2배 -> 4개
 * 18 : 동결 -> 4개
 * 21 : 2배 -> 8개
 * 
 * 24 : 2개
 * 27 : 2배 -> 4개
 * 30 : 동결 -> 4개
 * 33 : 2배 -> 8개
 * 36 :
 */