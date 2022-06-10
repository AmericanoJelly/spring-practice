package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))")
	public void beforAdvice() {
		 System.out.println("====Before Advice====");
	}
	
	@After ("execution(* *..*.ProductService.find(..))") //리턴타입*, 패키지 줄이기*..*, 시그니처 줄이기..
	public void afterAdvice() {
		 System.out.println("====After Advice====");
	}
	
	@AfterReturning ("execution(* *..*.ProductService.*(..))") //모든 메소드 적용
	public void afterReturningAdvice() {
		 System.out.println("====After Returning Advice====");
	}
	
	@AfterThrowing (value="execution(* *..*.*.*(..))", throwing="ex") 
	//ex: * *..controller*.*.*(..))컨트롤러 패키지에있는 모든 메소드의 모든 예외는 여기로 옴
	public void afterThrowingAdvice(Throwable ex) {
		 System.out.println("====After Throwing Advice " + ex + "====");
	}
	
	@Around("execution(* *..*.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		/* before */
		 System.out.println("====Around before Advice====");
		// PointCut 메소드 실행
		
		 // Object result = pjp.proceed();
		 //파라미터 가로채기
		 Object[] params = {"Camera"};
		 Object result = pjp.proceed(params);
		 
		
		/* after */
		 System.out.println("====Around after Advice====");
		return result;
	}
}
