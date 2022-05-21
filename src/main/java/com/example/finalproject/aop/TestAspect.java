package com.example.finalproject.aop;

import com.example.finalproject.models.Test;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
@Slf4j
public class TestAspect {

    @Pointcut("execution(* com.example.finalproject.service.impl.TestService.save(..))")
    public void addTest(){

    }

    @Pointcut("execution(* com.example.finalproject.service.impl.TestService.findAll(..))")
    public void findAllTests(){

    }

    @Before("findAllTests()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("Before getting all vacancies...");
    }


    @After("findAllTests()")
    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("Vacancies:" , joinPoint.getArgs());
    }


    @AfterReturning(pointcut = "findAllTests()",
            returning = "object")
    public void afterReturning(JoinPoint joinPoint, Object object) {
        log.info("After returning");
        log.info("Method: " , joinPoint.getSignature().toShortString());
        log.info("Object: "+ object);
    }


    @Around("addTest()")
    public Object around(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (methodSignature.getName().equals("addTest")) {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof Test) {
                    Test test = (Test) arg;
                    log.info("Around");
                    log.info("Added test id:", test.getId());
                    log.info("Added test name:", test.getName());
                }
            }
        }

        Object object = null;
        try {
            object = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return object;
    }
}
