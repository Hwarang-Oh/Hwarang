package com.ssafy.day8.c_stream.terminate;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AggregateTest {

    public static void main(String[] args) throws IOException {
        
        IntStream is = new Random().ints(10, 1, 6);
        System.out.println("총합은: " + is.sum());

        String[] strs = {  };
        Optional<String> optionalMax = Arrays.stream(strs).max(String::compareTo);
        
        System.out.println(optionalMax.orElseGet(()->"최대값을 구할 수 없어요."));
        
        optionalMax.ifPresent(val -> {
            System.out.println("최대값은: " + val);
        });

        System.out.println(optionalMax.filter(val -> val.matches("[가-힣]{1,}")).orElse("한글 중에는 없다."));
        

    }
}
