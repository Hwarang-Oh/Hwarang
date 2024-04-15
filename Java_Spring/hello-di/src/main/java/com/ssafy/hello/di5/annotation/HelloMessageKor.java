package com.ssafy.hello.di5.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

	@Component(value = "kor")
	@Scope(value = "singleton")
	public class HelloMessageKor implements HelloMessage {
		
		public HelloMessageKor() {
			System.out.println("HelloMessageKor Contructor Call!!!!!!!!!");
		}
	
		public String hello(String name) {
			return "안녕하세요 " + name;
		}
		
	}
