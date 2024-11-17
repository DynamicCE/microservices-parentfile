package com.erkan.accounts.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("within(com.erkan.accounts.service..*)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        logger.info("Entering method [{}] in class [{}] with arguments {}",
                methodName, className, joinPoint.getArgs());

        Object result = joinPoint.proceed();

        stopWatch.stop();
        logger.info("Exiting method [{}] in class [{}] with result: {} (Execution time: {} ms)",
                methodName, className, result, stopWatch.getTotalTimeMillis());

        return result;
    }
}