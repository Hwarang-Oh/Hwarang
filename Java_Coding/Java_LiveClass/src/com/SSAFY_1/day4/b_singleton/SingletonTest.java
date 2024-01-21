package com.SSAFY_1.day4.b_singleton;

class SingletonClass extends Object { // extends Object는 기본적으로,,,
  // TODO:SingletonClass에 Singleton Design Pattern을 적용하시오.
  private SingletonClass() { // public -> private
    super(); // this, super 명시 안하면, super
  } // 기본적으로 생략되어 있는 것, ( 생성자를 만들지 않았기에 )

  private static SingletonClass instance = new SingletonClass();
  public static SingletonClass getInstance() {
    return instance;
  }
  // END
  public void sayHello() {
    System.out.println("Hello");
  }

}

public class SingletonTest {
  public static void main(String[] args) {
    // TODO:SingletonClass를 사용해보세요.
    SingletonClass sc1 = SingletonClass.getInstance();
    SingletonClass sc2 = SingletonClass.getInstance();
    sc1.sayHello();
    sc2.sayHello();
    System.out.println(sc1 == sc2);
    // END
  }
}
