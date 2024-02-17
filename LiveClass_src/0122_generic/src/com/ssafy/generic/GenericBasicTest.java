package com.ssafy.generic;

import java.util.ArrayList;
import java.util.Date;

public class GenericBasicTest {

	public static void main(String[] args) {
//		ArrayList list = new ArrayList();
//		list.add("ssafy");
//		list.add(Integer.valueOf(10));
//		list.add(new Date());
//		
//		String a = (String)list.get(0);
//		String b = (String)list.get(1);
//		
//		System.out.println(a);
//		System.out.println(b);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list.add("ssafy");
		list.add("서울11반");
		
		list2.add(11);
		
		String a = list.get(0);
		String b = list.get(1);
		
		System.out.println(a);
		System.out.println(b);
		
	}

}
