package com.ssafy.step1.aop.xml;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
  public void beforeLogging(JoinPoint joinPoint) {
    System.out.println("Method 호출 전..." + joinPoint.getSignature().getName());
    System.out.println("매개변수 : " + joinPoint.getArgs()[0]);
  }
}
