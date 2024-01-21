package com.SSAFY_1.day4.c_polymorphism;

public class InstanceOfTest {
    private void unsafeCasting() {
        Object obj = 1;
        String s = (String) obj; // 겉보기에는, 문법적으로 괜찮아 보이지만..
        // 위 Code의 시도는, Intger -> String으로 바꾸려는 것 => 오류
        // Compile 과정에서는 오류가 없었는데, 실제 진행하면서 메모리 확인하는 과정 중에 오류
        System.out.println(s.length());
    }

    private void safeCasting() {
        Object obj = 1;
        if (obj instanceof String) {
            String s = (String) obj;
        }
        else {
            System.out.println("It is Not String");
        }
    }

    public static void main(String[] args) {
        InstanceOfTest instance = new InstanceOfTest();
//        instance.unsafeCasting();
        instance.safeCasting();
    }
}
