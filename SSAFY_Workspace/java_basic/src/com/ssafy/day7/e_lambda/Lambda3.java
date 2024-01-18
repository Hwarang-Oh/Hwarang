package com.ssafy.day7.e_lambda;

import java.awt.Checkbox;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lambda3 {

    public static void main(String[] args) {

    }

    private static void methodRef1() {
        // 다음 배열을 다양한 방식(anonymous inner class, lambda, 메서드 참조)으로 정렬해보자.
        Integer[] nums = { 1, 5, 4, 3, 8, 9 };
        // TODO: 위 배열을 숫자 오름차순으로 정렬하시오.

        // END
    }

    private static void methodRef2() {
        List<String> names = new ArrayList<>(Arrays.asList("Hello", "Java", "World"));
        names.forEach(item -> names.add(item));
        names.forEach(names::add);

        // TODO: forEach를 이용하여 names의 내용을 출력하세요.

        // END
    }

    private static void constructorRef() {
        Supplier<StringBuffer> s1 = ()-> new StringBuffer();
        Supplier<StringBuffer> s2 = StringBuffer::new;

        Function<String, StringBuffer> f1 = (init)-> new StringBuffer();
        Function<String, StringBuffer> f2 = StringBuffer::new;

        // TODO: java.awt.Checkbox 객체를 다양한 생성자 참조로 만들어보자.

        // END

    }
}
