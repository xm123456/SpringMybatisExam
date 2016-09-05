package com.hand.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ��־������
 */
@Aspect // ����������
public class LogAnnotationAspect {
	// ���������
	@Pointcut("execution(* com.hand.AOP.CanAddToDb.AddIdEntity(..))")
	private void allMethod() {
	}

	// ���ָ�����������ʽѡ��������Ӧ��ǰ��֪ͨ
	@Before("allMethod()")
	public void before(JoinPoint call) {
		System.out.println("Before Insert Customer Data");
	}

	// ���������������Ӧ�ú���֪ͨ
	// @AfterReturning("allMethod()")
	public void afterReturn() {
	}

	// Ӧ������֪ͨ
	@After("allMethod()")
	public void after() {
		System.out.println("After Insert Customer Data");
	}

	// Ӧ���쳣�׳���֪ͨ
	// @AfterThrowing("allMethod()")
	public void afterThrowing() {
		System.out.println("��ע��-�쳣�׳���֪ͨ��:����ִ��ʱ���쳣��");
	}

	// Ӧ����Χ֪ͨ
	// @Around("allMethod()")
	public Object doAround(ProceedingJoinPoint call) throws Throwable {
		Object result = null;
		this.before(call);// �൱��ǰ��֪ͨ
		try {
			result = call.proceed();
			this.afterReturn(); // �൱�ں���֪ͨ
		} catch (Throwable e) {
			this.afterThrowing(); // �൱���쳣�׳���֪ͨ
			throw e;
		} finally {
			this.after(); // �൱������֪ͨ
		}

		return result;
	}
}