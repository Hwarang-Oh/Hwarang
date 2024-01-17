package com.ssafy.day3.a_inheritance;

public class SpiderMan extends Person{// is a 관계
	boolean isSpider;
	Spider spider; // has a 관계, Reference Type -> NULL
	
	public SpiderMan() {
		// super();
		this("피터 파커"); // 다른 생성자를 부름 
	}
	
	public SpiderMan(String name) {
		super(name); // 부모의 생성자에 인자와 함께 넘긴다?
		this.spider = new Spider();
	}
	
	void fireWeb() {
		if (isSpider) {
			spider.fireWeb();
		}
		else
			System.out.println("되겠노");
	}
	
	@Override // 컴파일러에게 재정의된 메서드임을 알려줌. -> Override가 잘못되면, 컴파일러가 바로 알려줌.
	void jump() { // Overridng -> main을 바꾸지 않아도 수정의 원활함.
		if (isSpider) {
			spider.jump();
		}
		else
			super.jump();	
	}
}
