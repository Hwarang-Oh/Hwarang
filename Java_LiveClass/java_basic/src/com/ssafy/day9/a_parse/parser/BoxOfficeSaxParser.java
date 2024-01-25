package com.ssafy.day9.a_parse.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.day9.a_parse.dto.BoxOffice;

public class BoxOfficeSaxParser extends DefaultHandler implements BoxOfficeParser {
    // TODO: singleton 형태로 작성해보자.

    // END

    // 파싱된 내용을 저장할 List
    private List<BoxOffice> list ;
    // 현재 파싱하고 있는 대상 객체
    private BoxOffice current;
    // 방금 읽은 텍스트 내용
    private String content;

    @Override
    public List<BoxOffice> getBoxOffice(InputStream resource) {
        list = new ArrayList<>();
        // TODO: SAXParser를 구성하고 boxoffice.xml을 파싱하시오.

        // END
        return list;
    }

    // TODO: 필요한 매서드를 재정의 하여 boxOffice.xml을 파싱하시오.

    // END
}
