package com.ssafy.day7.d_sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ssafy.day7.b_set.SmartPhone;

public class ListSortTest {

    private List<String> names = Arrays.asList("Hi", "Java", "World", "Welcome");

    public void basicSort() {
        // TODO: names를 이름의 오름차순, 또는 그 역순으로 정렬해서출력하시오.
    	Collections.sort(names);
    	System.out.println("정렬 후 : " + names);
        // END
    }

    public void sortPhone() {
    	List<SmartPhone> phones = Arrays.asList(new SmartPhone("010"), new SmartPhone("011"),
    			new SmartPhone("012"));
    	Collections.sort(phones);
    	System.out.println("정렬 후 : " + phones);
    }

    public void stringLengthSort() {
        // TODO: 문자열의 길이에 따라 names를 정렬해보자.

        // END
        System.out.println(names); // [Hi, Java, World, Welcome]
    }

    public static void main(String[] args) {
        ListSortTest st = new ListSortTest();
        st.basicSort();
        st.sortPhone();
        // st.stringLengthSort();
    }

}
