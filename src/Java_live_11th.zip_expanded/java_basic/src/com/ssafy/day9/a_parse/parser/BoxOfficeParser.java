package com.ssafy.day9.a_parse.parser;

import java.io.InputStream;
import java.util.List;

import com.ssafy.day9.a_parse.dto.BoxOffice;

public interface BoxOfficeParser {

    public abstract List<BoxOffice> getBoxOffice(InputStream resource);
}
