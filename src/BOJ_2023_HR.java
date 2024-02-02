import java.io.*;
import java.util.*;

public class BOJ_2023_HR {
	
	static ArrayList<ArrayList<Integer>> digitPrime;
	static ArrayList<Integer> eachDigitPrime;
	static int[] possPrime = {1,3,5,7,9};
	static int prime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int digit = Integer.parseInt(input.readLine());
		
		digitPrime = new ArrayList<ArrayList<Integer>>();
		eachDigitPrime = new ArrayList<Integer>();
		eachDigitPrime.add(2);
		eachDigitPrime.add(3);
		eachDigitPrime.add(5);
		eachDigitPrime.add(7);
		digitPrime.add(eachDigitPrime);
		
		for (int i = 1 ; i < digit ; i++)
			getPrime(i);
		
		for (int eachNum : eachDigitPrime)
			sb.append(eachNum).append("\n");
		System.out.print(sb);
	}

	public static void getPrime(int eachDigit) {
		eachDigitPrime = new ArrayList<Integer>();
		
		for (int i = 0 ; i < digitPrime.get(eachDigit -1).size() ; i++) {
			prime = digitPrime.get(eachDigit -1).get(i) * 10;
			for (int j = 0 ; j < possPrime.length ; j++)
				if (check(prime + possPrime[j]))
					eachDigitPrime.add(prime + possPrime[j]);	
		}
		digitPrime.add(eachDigitPrime);
	}
	
	public static boolean check(int number) {
		for (int i = 3 ; i * i <= number ; i += 2) {
			if (number % i == 0)
				return false;
		}
		return true;
	}
}






// 두개의 집단에서 뽑아야 하는그런 느낌 
