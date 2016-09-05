package com.hand.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 日志切面类
 */
@Aspect // 定义切面类
public class LogAnnotationAspect {
	// 定义切入点
	@Pointcut("execution(* com.hand.AOP.CanAddToDb.AddIdEntity(..))")
	private void allMethod() {
	}

	// 针对指定的切入点表达式选择的切入点应用前置通知
	@Before("allMethod()")
	public void before(JoinPoint call) {
		System.out.println("Before Insert Customer Data");
	}

	// 访问命名切入点来应用后置通知
	// @AfterReturning("allMethod()")
	public void afterReturn() {
	}

	// 应用最终通知
	@After("allMethod()")
	public void after() {
		System.out.println("After Insert Customer Data");
	}

	// 应用异常抛出后通知
	// @AfterThrowing("allMethod()")
	public void afterThrowing() {
		System.out.println("【注解-异常抛出后通知】:方法执行时出异常了");
	}

	// 应用周围通知
	// @Around("allMethod()")
	public Object doAround(ProceedingJoinPoint call) throws Throwable {
		Object result = null;
		this.before(call);// 相当于前置通知
		try {
			result = call.proceed();
			this.afterReturn(); // 相当于后置通知
		} catch (Throwable e) {
			this.afterThrowing(); // 相当于异常抛出后通知
			throw e;
		} finally {
			this.after(); // 相当于最终通知
		}

		return result;
	}
}