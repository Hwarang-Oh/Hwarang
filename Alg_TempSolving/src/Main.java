import java.io.*;

public class Main {

    static class Solution {
        int ipt, result;

        void run() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            this.ipt = Integer.parseInt(input.readLine());
            switch (this.ipt) {
                case 0:
                    this.result = 1;
                    break;
                case 1:
                    this.result = 1;
                    break;
                case 2:
                    this.result = 2;
                    break;
                case 3:
                    this.result = 6;
                    break;
                case 4:
                    this.result = 24;
                    break;
                case 5:
                    this.result = 120;
                    break;
                case 6:
                    this.result = 720;
                    break;
                case 7:
                    this.result = 5040;
                    break;
                case 8:
                    this.result = 40320;
                    break;
                case 9:
                    this.result = 362880;
                    break;
                case 10:
                    this.result = 3628800;
                    break;
                case 11:
                    this.result = 39916800;
                    break;
                case 12:
                    this.result = 479001600;
            }
            System.out.println(this.result);
        }
    }

    public static void main(String[] args) throws IOException {
        Solution Solution = new Solution();
        Solution.run();
    }
}
