package com.erkan.accounts.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

@Aspect
@Component
public class PerformanceMonitoringAspect {

    private final MeterRegistry meterRegistry;

    public PerformanceMonitoringAspect(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Around("@annotation(com.erkan.accounts.annotation.TrackPerformance)")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        String className = methodSignature.getDeclaringType().getSimpleName();

        Timer timer = Timer.builder("method.execution.time")
                .tag("class", className)
                .tag("method", methodName)
                .description("Method execution time measurement")
                .register(meterRegistry);

        return timer.record(() -> {
            try {
                return joinPoint.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
    }
}