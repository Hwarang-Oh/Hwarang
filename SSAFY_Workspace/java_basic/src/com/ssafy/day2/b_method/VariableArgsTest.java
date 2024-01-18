package com.ssafy.day2.b_method;

public class VariableArgsTest {
    public static void main(String[] args) {
        VariableArgsTest vt = new VariableArgsTest();
        vt.variableArgs(1, 2, 3);
        vt.variableArgs(1, 2, 3, 4, 5);
        vt.variableArgs(1, 2);
    }

    public void variableArgs(int... params) {
        int sum = 0;
        for (int i : params) {
            sum += i;
        }
        System.out.println(sum);
    }

}
