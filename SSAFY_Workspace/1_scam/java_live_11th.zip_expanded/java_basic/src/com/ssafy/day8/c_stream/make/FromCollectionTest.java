package com.ssafy.day8.c_stream.make;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FromCollectionTest {

    public static void main(String[] args) {
        String[] heroes = { "아이언맨", "스파이더맨", "헐크", "토르" };
        Stream<String> fromArray = Arrays.stream(heroes);

        List<String> heroList = Arrays.asList(heroes);
        Stream<String> fromList = heroList.stream();
        fromList.forEach(a -> System.out.print("[" + a + "], "));
    }
}
