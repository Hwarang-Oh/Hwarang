package com.ssafy.day8.c_stream.terminate;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingTest {
    private static Locale[] locales = Locale.getAvailableLocales();


    
    private static void groupingByTest() {
        System.out.println("한국어가 사용되는 Locale은?");
        Map<String, List<Locale>> langInfo1 = Arrays.stream(locales).collect(Collectors.groupingBy(locale -> {
            return locale.getLanguage();
        }));

        langInfo1.get("ko").stream().forEach(locale -> {
            System.out.printf("국가코드: %s, 국가명: %s, 언어명: %s\n", locale.getCountry(), locale.getDisplayCountry(), locale.getDisplayName());
        });
        System.out.println("Locale 별 사용 국가의 수는 ?");
        Map<String, Long> langInfo2 = Arrays.stream(locales).collect(Collectors.groupingBy(locale -> {
            return locale.getLanguage();
        }, Collectors.counting()));
        
        System.out.println(langInfo2);
    }
    
    private static void partitioningByTest() {
        
        Map<Boolean, List<Locale>> langInfo1 = Arrays.stream(locales).collect(Collectors.partitioningBy(locale -> {
            return locale.getLanguage().equals("ko");
        }));
        System.out.printf("비 한국어 Locale의 수: %d\n",langInfo1.get(false).size());
        
        Map<Boolean, Long> langInfo2 = Arrays.stream(locales).collect(Collectors.partitioningBy(locale -> {
            return locale.getLanguage().equals("ko");
        }, Collectors.counting()));
        System.out.printf("비 한국어 Locale의 수: %d\n",langInfo2.get(false));
        
    }
    
    public static void main(String[] args) {
//        groupingByTest();
        partitioningByTest();

    }
}
