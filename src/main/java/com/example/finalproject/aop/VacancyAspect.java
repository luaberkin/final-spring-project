package com.example.finalproject.aop;

import com.example.finalproject.models.Vacancy;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
@Slf4j
public class VacancyAspect {

    @Pointcut("execution(* com.example.finalproject.service.impl.VacancyService.save(..))")
    public void addVacancy(){

    }

    @Pointcut("execution(* com.example.finalproject.service.impl.VacancyService.findAll(..))")
    public void findAllVacancies(){

    }

    @Before("findAllVacancies()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("Before getting all vacancies...");
    }


    @After("findAllVacancies()")
    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("Vacancies:" , joinPoint.getArgs());
    }


    @AfterReturning(pointcut = "findAllVacancies()",
            returning = "object")
    public void afterReturning(JoinPoint joinPoint, Object object) {
        log.info("After returning");
        log.info("Method: " , joinPoint.getSignature().toShortString());
        log.info("Object: "+ object);
    }


    @Around("addVacancy()")
    public Object around(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (methodSignature.getName().equals("addVacancy")) {
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof Vacancy) {
                    Vacancy vacancy = (Vacancy) arg;
                    log.info("Around");
                    log.info("Added vacancy id:", vacancy.getId());
                    log.info("Added vacancy name:", vacancy.getName());
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
