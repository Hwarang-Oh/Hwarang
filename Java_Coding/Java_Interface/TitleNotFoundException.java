package com.SSAFY_1.day6.Movie;

public class TitleNotFoundException extends Exception{
    private String title;
    public TitleNotFoundException(String title){
        super(title + " 검색어에 해당하는 영화는 존재하지 않습니다.");
    }
    public String getTitle(){
        return this.title;
    }

}
