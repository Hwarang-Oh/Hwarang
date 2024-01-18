package com.ssafy.day7.e_lambda;

public class Lambda1 {

    @FunctionalInterface
    interface MyFunctional1 {
        void sayHello(String name);
    }

    @FunctionalInterface
    interface MyFunctional2 {
        double numTo(int num);
    }

    private static void myFunctional1Test(MyFunctional1 function, String name) {
        function.sayHello(name);
    }

    private static void myFunctional2Test(MyFunctional2 function, int num) {
        System.out.println(function.numTo(num));
    }

    public static void main(String[] args) {
        myFunctional1Test((String str) -> {
            System.out.println(str);
        }, "hong");
        
        myFunctional1Test((str) -> {
            System.out.println(str);
        }, "hong");
        
        myFunctional1Test(str -> System.out.println(str), "hong");
        
        myFunctional2Test(num -> {
            System.out.println(num);
            return num * 2;
        }, 10);
        
        myFunctional2Test(num-> num*2, 10);
    }

}
