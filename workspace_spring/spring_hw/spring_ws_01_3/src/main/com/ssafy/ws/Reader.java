package main.com.ssafy.ws;

import org.springframework.stereotype.Service;

@Service("reader")
public class Reader {

	private Book book;

	public Reader(Book book) {
		this.book = book;
	}

	public void Read() {
		book.getInfo();
	}
}
