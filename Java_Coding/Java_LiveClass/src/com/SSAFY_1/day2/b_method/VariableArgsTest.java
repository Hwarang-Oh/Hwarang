package com.SSAFY_1.day2.b_method;

public class VariableArgsTest {
    public static void main(String[] args) {
        VariableArgsTest vt = new VariableArgsTest();
        vt.variableArgs(1, 2, 3);
        vt.variableArgs(1, 2, 3, 4, 5);
        vt.variableArgs(1, 2);
    }

    public void variableArgs(int... params) { // 0개 이상, printf Method도 Vargs가 적용된 것
        int sum = 0;
        for (int i : params) {
            sum += i;
        }
        System.out.println(sum);
    }
}
