package com.ssafy.day8.c_stream.terminate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MatchingTest {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./src/res/강남스타일.txt"));
        boolean anyMatch = lines.stream()
                                .flatMap(line-> Arrays.stream(line.split("\\b")))
                                .peek(System.out::println).distinct()
                                .anyMatch(word -> word.length()>5);
        

        System.out.println("stream의 단어들에는 5글자 이상인 것이 있다? " + anyMatch);
    }
}
