package com.ssafy.day8.a_node;

import java.io.File;
import java.io.IOException;

public class UseFileTest {

    public static void main(String[] args) {
        try {
            // 절대 경로
            File temp = new File("c:\\Temp");
            System.out.printf("존재? %b, 디렉토리? %b%n", temp.exists(), temp.isDirectory());

            // 상대경로
            File current = new File(".");
            System.out.printf("여기는 어디? %s%n", current.getCanonicalPath());

            // 상대경로의 기준은 java program을 실행하는 위치(소스와 무관)
            // d:\>java -cp .;[project_root]\bin [package].UseFileStream

            // TODO: readme.txt에 해당하는 File 객체를 만들어 보자.
            //  프로젝트와 무관하게 파일을 찾을 때(절대 경로)
            //  프로젝트 내부에서 파일을 찾을 때(상대 경로)
            //  특정 클래스 기준으로 파일을 찾을 때

            // END
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
