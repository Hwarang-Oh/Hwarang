package com.ssafy.day7.e_lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class FunctionalApiTest {
    private Map<String, Integer> grades;

    private void setup() {
        grades = new HashMap<>();
        grades.put("hong", 100);
        grades.put("jang", 80);
        grades.put("lim", 95);
        grades.put("kim", 90);
    }

    public static void main(String[] args) {
        FunctionalApiTest fpt = new FunctionalApiTest();
        fpt.setup();
        fpt.consumerTest();
        fpt.supplierTest();
        fpt.functionTest();
        fpt.operationTest();
        fpt.predicateTest();
    }

    public void consumerTest() {
        // TODO: map의 각 요소를 이름:점수의 형태로 출력해보자.

        // END
    }

    public void supplierTest() {
        Integer score = grades.get("steve");
        // TODO: 만약 score가 null이면 0~100 사이의 값을 설정해보자.

        // END
        System.out.println(score);

    }

    public void functionTest() {
        // TODO: grades에 jang이 있다면 기존 점수에 100점을 더해주세요.

        // END
        System.out.println(grades);
    }

    public void operationTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // TODO: 위 배열의 요소를 2배씩으로 대체 하세요.

        // END
        System.out.println(list);
    }

    public void predicateTest() {
        // TODO: grades의 Entry 중 name이 3자 넘고 score가 90점 이상인 것들을 삭제 후 출력해보자.

        // END
        System.out.println(grades);
    }

}
