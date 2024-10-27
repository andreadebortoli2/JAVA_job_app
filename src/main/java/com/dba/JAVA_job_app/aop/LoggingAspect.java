package com.dba.JAVA_job_app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // "execution(return-type package.className.methodName(args))"

    // @Before("execution(* *.*(..))")
    // before "all methods" syntax (not the best, it' called for everything)
    // @Before("execution(* com.dba.JAVA_job_app.service.JobService.*(..))")
    // before "all methods" in service-package.JobService.class
    @Before("execution(* com.dba.JAVA_job_app.service.JobService.getAllJobs(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method called: " + jp.getSignature().getName());
    }

    @After("execution(* com.dba.JAVA_job_app.service.JobService.getAllJobs(..))")
    public void logMethodExcecuted(JoinPoint jp) {
        LOGGER.info("Method executed: " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.dba.JAVA_job_app.service.JobService.addOrUpdateJob(..))")
    public void logMethodExcecutedSuccessfully(JoinPoint jp) {
        LOGGER.info("Method executed successfully: " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.dba.JAVA_job_app.service.JobService.addOrUpdateJob(..))")
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info("Method has some issues: " + jp.getSignature().getName());
    }
}
