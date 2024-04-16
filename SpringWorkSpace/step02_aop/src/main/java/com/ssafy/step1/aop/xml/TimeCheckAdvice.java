package com.ssafy.step1.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeCheckAdvice {
  public Object checkTime(ProceedingJoinPoint proceedingJoinPoint) {

    Object res = null;
    try {
      // Before
      System.out.println("시간 체크 시작...");
      long start = System.nanoTime();
      proceedingJoinPoint.proceed();

      // After Returning
      long end = System.nanoTime();
      System.out.println((end - start) + "ns");
    } catch (Throwable e) {
      // After Throwing
      e.printStackTrace();
    } finally {
      // After 
    }
    return res;
  }
}