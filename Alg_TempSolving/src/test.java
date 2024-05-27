import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int qCnt = Integer.parseInt(input.readLine());
        String eachQuiz;
        int eachTotal, eachAdd;
        for (int i = 0; i < qCnt; i++) {
            eachTotal = eachAdd = 0;
            eachQuiz = input.readLine();
            for (int j = 0; j < eachQuiz.length(); j++) {
                if (eachQuiz.charAt(j) == 'O') {
                    eachAdd++;
                    eachTotal += eachAdd;
                } else {
                    eachAdd = 0;
                }
            }
            sb.append(eachTotal).append("\n");
        }
        System.out.print(sb);
    }
}