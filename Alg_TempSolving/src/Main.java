import java.io.*;
import java.time.LocalDate;

public class Main {
    static class Solution {
        void run() throws IOException {
            System.out.println(LocalDate.now());
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.run();
    }
}
