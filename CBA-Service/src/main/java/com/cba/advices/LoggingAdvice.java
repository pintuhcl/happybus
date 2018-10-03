package com.cba.advices;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LoggingAdvice {
@Before(value="within(com.cba.processing..*)")
	public void beforeAdvice(JoinPoint joinPoint){
	Logger logger=Logger.getLogger(joinPoint.getTarget().getClass().getName());
	logger.info("Entered into "+joinPoint.getSignature().getName()+" with no of args  "+joinPoint.getArgs().length);
}
@AfterReturning(returning="returnValue",pointcut="within(com.cba.processing..*)")
public void afterAdvice(JoinPoint joinPoint,Object returnValue){
	Logger logger=Logger.getLogger(joinPoint.getTarget().getClass().getName());
logger.info("Execution completed on "+joinPoint.getSignature().getName()+" retrun value is : "+returnValue);
}

}
