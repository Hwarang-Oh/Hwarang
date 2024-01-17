package com.ssafy.day9.a_parse.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import com.ssafy.day9.a_parse.dto.BoxOffice;
import com.ssafy.day9.a_parse.parser.BoxOfficeJsonParser;
import com.ssafy.day9.a_parse.parser.BoxOfficeParser;

public class BoxOfficeCLI {
    private BoxOfficeParser parser = null;
    private InputStream resource = null;

    public BoxOfficeCLI() {

    }

    private void readBoxOfficeList() {
        
        // TODO: resource와 parser를 구성해서 정보를 가져와보자.

        // END
        
        
        List<BoxOffice> list = parser.getBoxOffice(resource);
        System.out.println("list size: " + list.size());
        for (BoxOffice boxOffice : list) {
            System.out.println(boxOffice);
        }
    }

    public static void main(String[] args) {
        BoxOfficeCLI cli = new BoxOfficeCLI();
        cli.readBoxOfficeList();
    }
}
