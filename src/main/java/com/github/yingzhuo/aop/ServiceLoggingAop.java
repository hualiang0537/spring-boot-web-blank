package com.github.yingzhuo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

@Aspect
public class ServiceLoggingAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLoggingAop.class);

    private boolean enabled = true;

    @Around("execution(public * com.github.yingzhuo.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        if (enabled == false) {
            return joinPoint.proceed();
        } else {
            final Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
            long start = System.currentTimeMillis();
            final Object obj = joinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("{} - ({} millis)", method, end - start);
            return obj;
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
