package com.ssafy.day8.c_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOrNot {
    // 주어진 목록에서 글자수가 3자가 넘는 요소들의 글자수 평균은?
    List<String> heroes = Arrays.asList("아이언맨", "스파이더맨", "헐크", "캡틴아메리카", "토르");

    public void oldStyle() {
        double sum = 0;
        int cnt = 0;
        for (String hero : heroes) {
            int length = hero.length();                 // 글자 수로 변환
            if (length > 3) {                           // 필터링
                sum += length;                          // 평균을 위해 합계 및 카운팅
                cnt++;
            }
        }
        double avg = sum / cnt;                         // 결과
        System.out.println(avg);
    }

    public void streamStyle() {
        double avg = heroes.stream()
                           .mapToInt(String::length)    // 글자 수로 변환 
                           .filter(len -> len>3)        // 필터링
                           .average()                   // 평균
                           .getAsDouble();              // 결과
        System.out.println(avg);
    }

    public static void main(String[] args) {
        StreamOrNot sornot = new StreamOrNot();
        sornot.oldStyle();
        sornot.streamStyle();
    }

}
