import java.util.*;
import java.io.*;


public class Insertion_Sort_HR {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(input.readLine());
        ArrayList<Integer> num_list = new ArrayList<>();

        while(ST.hasMoreTokens()){
            num_list.add(Integer.parseInt(ST.nextToken()));
        }
        System.out.println(num_list.toString());
        int min_index = 0;
        for (int i = 1 ; i < num_list.size() ; i++){
            min_index = i
            for (int j = i - 1 ; j >= 0 ; j--) {
                if (num_list.get(i) < num_list.get(i))
                    break;
                else {
                    min_index = j
                }
            }
        }
    }
}
