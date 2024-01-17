package com.ssafy.day6.e_etc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingTimeTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        test('E');
        test('L');
        
        // useScannerBad();
        // useScannerGood();
    }

    private static int[] nums;

    private static void test(char type) {
        long start = System.nanoTime();
        if (type == 'E') {
            endByException();
        } else {
            endByLength();
        }
        long end = System.nanoTime();
        System.out.printf("%c - %d%n", type, end - start);
    }

    private static void endByException() {
        int sum = 0;
        try {
            for (int i = 0;; i++) {
                sum += nums[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }

    private static void endByLength() {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println(sum);
    }

    private static void useScannerBad() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        try {
            while (true) {
                int input = scanner.nextInt();
                if (input == 0) {
                    break;
                } else {
                    sum += input;
                }
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        scanner.close();
        System.out.printf("bad case sum: %d%n", sum);
    }

    private static void useScannerGood() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        // TODO: Scanner를 통해서 int 범위의 숫자가 입력될 때까지만 입력값을 더하도록 처리해보자.

        // END
        scanner.close();
        System.out.printf("good case sum: %d%n", sum);
    }
}
