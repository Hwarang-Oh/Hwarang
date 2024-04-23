package com.ssafy.step2.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component("logAdvice")
public class LogAdvice {
  @Pointcut("execution(* *(*))")
  public void allMethodPointcut() {
  }

  @Before("allMethodPointcut()")
  public void beforeLogging(JoinPoint joinPoint) {
    System.out.println("Method 호출 전..." + joinPoint.getSignature().getName());
    System.out.println("매개변수 : " + joinPoint.getArgs()[0]);
  }
}
