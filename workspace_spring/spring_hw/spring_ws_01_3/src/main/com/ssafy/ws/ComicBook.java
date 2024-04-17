package main.com.ssafy.ws;

import org.springframework.stereotype.Service;

@Service("book")
public class ComicBook implements Book {

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		System.out.println("만화책을(를) 열심히 읽습니다.");
	}
}
