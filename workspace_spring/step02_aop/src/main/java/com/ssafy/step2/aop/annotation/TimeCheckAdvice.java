package com.ssafy.step2.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component("timeAdvice")
public class TimeCheckAdvice {

  @Around("execution(* *(..))")
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