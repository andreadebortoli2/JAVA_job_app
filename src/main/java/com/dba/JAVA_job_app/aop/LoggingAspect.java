package com.dba.JAVA_job_app.aop;

import org.aspectj.lang.JoinPoint;
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
    public void logMethodCallpp(JoinPoint jp) {
        LOGGER.info("Method called: " + jp.getSignature().getName());
    }
}
