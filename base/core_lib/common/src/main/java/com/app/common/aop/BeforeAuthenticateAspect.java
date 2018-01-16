package com.app.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAuthenticateAspect {

	@Before("@annotation(com.app.common.annotation.BeforeAuth)")
	public void setAuthentication(JoinPoint joinPoint) {
		System.out.println(joinPoint);
	}
}
