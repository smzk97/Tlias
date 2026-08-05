package org.example.tliaswebmanagement.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.tliaswebmanagement.EntityClass.OperateLog;
import org.example.tliaswebmanagement.Mapper.LogMapper;
import org.example.tliaswebmanagement.Utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperateLogAspect {

    private final LogMapper logMapper;
    @Autowired
    public OperateLogAspect(LogMapper logMapper) {
        this.logMapper = logMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Around("@annotation(org.example.tliaswebmanagement.Annotation.OperateLog)")
    public Object operateLog(ProceedingJoinPoint pjp) throws Throwable {

        long begin = System.currentTimeMillis();
        Object object = pjp.proceed();
        long end = System.currentTimeMillis();

        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(Integer.parseInt(ThreadLocalUtil.getCurrentId().toString()));
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(pjp.getTarget().getClass().getName());
        operateLog.setMethodName(pjp.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(pjp.getArgs()));
        operateLog.setReturnValue(object != null ? object.toString() : "void");
        operateLog.setCostTime(end - begin);

        log.info(operateLog.toString());
        logMapper.insertLogData(operateLog);

        ThreadLocalUtil.removeCurrentId();
        return object;

    }
}

