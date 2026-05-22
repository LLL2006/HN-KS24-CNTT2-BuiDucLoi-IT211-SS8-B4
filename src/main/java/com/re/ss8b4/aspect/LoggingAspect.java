package com.re.ss8b4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @AfterThrowing(
            pointcut =
                    "execution(* com.re.ss8b4.service.*.*(..))",
            throwing = "ex"
    )
    public void logException(JoinPoint joinPoint, Exception ex) {

        String className =
                joinPoint.getTarget()
                        .getClass()
                        .getSimpleName();

        String methodName =
                joinPoint.getSignature()
                        .getName();

        System.out.println(
                "[SECURITY LOG] " +
                        "Class: " + className +
                        " | Method: " + methodName +
                        " | Error: " + ex.getMessage()
        );
    }
}