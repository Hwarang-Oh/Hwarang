package com.ssafy.day8.c_stream.terminate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectTest {

    public static void main(String[] args) {
        String[] strs = { "Kotlin", "C", "Java", "Sql", "JavaScript", "Python" };

        List<String> list = Arrays.stream(strs).filter(str -> str.length() >= 3).collect(Collectors.toList());
        System.out.println(list.getClass().getName() + " : " + list);

        Map<String, Integer> map1 = Arrays.stream(strs)
                .collect(Collectors.toMap(str -> str, str -> str.length()));
        System.out.println(map1.getClass().getName() + " : " + map1);

        Map<Integer, List<String>> map2 = Arrays.stream(strs)
                .collect(Collectors.toMap(
                        str -> str.length(),
                        str -> {
                            List<String> items = new ArrayList<>();
                            items.add(str);
                            return items;
                        },
                        (oldVal, newVal) -> {
                            oldVal.addAll(newVal);
                            return oldVal;
                        }));

        System.out.println(map2.getClass().getName() + " : " + map2);

    }
}
