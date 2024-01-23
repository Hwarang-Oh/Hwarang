package com.ssafy.day7.e_lambda;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
    private String[] langs = { "Java", "C", "JavaScript", "Python" };

    public void sortByAnnonymous() {
        Arrays.sort(langs,
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2) * -1;
                    }
                });

        System.out.println("문자열 내림차순: " + Arrays.toString(langs));
    }

    public void sortByLambda() {
        // TODO: lambda 식을 이용하여 langs를 문자열의 길이 순으로 오름차순 정렬하시오.

        // END
        System.out.println("길이 오름차순: " + Arrays.toString(langs));
    }

    public static void main(String[] args) {
        SortTest st = new SortTest();

        st.sortByAnnonymous();
        st.sortByLambda();
    }
}
