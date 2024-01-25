package com.ssafy.day2.d_init;

public class InitializerTest {
    int iv;
    static int cv;

    static {
      System.out.println("static initializer");
      cv = 100;
    }

    {
      System.out.println("instance initializer");
      iv = 100;
    }

    public InitializerTest() {
      System.out.printf("생성자- iv: %d, cv: %d%n", iv, cv);
      this.iv = 300;
    }

    public static void main(String args[]) {
      InitializerTest it = new InitializerTest();
      System.out.printf("1 - cv: %d, iv: %d%n", cv, it.iv);
      InitializerTest it2 = new InitializerTest();
      System.out.printf("2 - cv: %d, iv: %d%n", cv, it2.iv);
    }
  }
