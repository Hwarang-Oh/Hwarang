package com.ssafy.day6.e_etc;

public class ThinkingAboutException {
    public void method(String[] args, String name, int divisor) {
        try {
            System.out.println(args[0]);

            System.out.println(name.length());

            System.out.println(1 / divisor);
        } catch (Exception e) {
            // 쉿!!!
        }
    }

    public void method2(String[] args, String name, int divisor) {
        if (args != null && args.length > 1) {
            System.out.println(args[0]);
        }

        if (name != null) {
            System.out.println(name.length());
        }

        if (divisor != 0) {
            System.out.println(1 / divisor);
        }
    }

    static int[] nums = { 1, 2, 3 };

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

}
