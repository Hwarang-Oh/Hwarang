package com.ssafy.day7.e_lambda;

@FunctionalInterface
interface MyFunctionalInterface {
    void useNumber(int num);

}

public class LambdaVariableTest {

    private int instanceMember = 10;

    public void useFIMethod(MyFunctionalInterface fi) {
        fi.useNumber(1);
    }

    public void lambdaMethodTest() {
        int localVar = 20;
        useFIMethod(num -> {
            // this는 외부 클래스의 instance
            System.out.printf("this: %s\n", this.getClass().getName());
            System.out.printf("멤버 변수 참조: %d\n", this.instanceMember++);
            System.out.printf("로컬 변수 참조: %d\n", localVar); // 읽기 전용 
            System.out.println(num++);
        });
        
        useFIMethod(new MyFunctionalInterface() {
            @Override
            public void useNumber(int num) {
                // this는 외부 클래스의 instance
                System.out.printf("this: %s\n", this.getClass().getName());
                System.out.printf("멤버 변수 참조: %d\n", LambdaVariableTest.this.instanceMember++);
                System.out.printf("로컬 변수 참조: %d\n", localVar); // 읽기 전용 
                System.out.println(num++);
            }
        });
    }

    public static void main(String[] args) {
        new LambdaVariableTest().lambdaMethodTest();
    }

}
