package org.example.tliaswebmanagement.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
@Component
public class RecordTimeAspect {

    @Pointcut("execution(* org.example.tliaswebmanagement.Service.Ipl.*.*(..))")
    private void exam(){}

    @Around("exam()")
    public Object RecordTime(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();

        Object result = pjp.proceed();

        long end = System.currentTimeMillis();
        log.info("{} 执行耗时 {} ms",pjp.getSignature(),end-begin);

        return result;
    }

    @Before("@annotation(org.springframework.context.annotation.Configuration)")
    public void object(){}
}
