package com.kodilla.patterns2.aop.watcher;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class Watcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& target(obj)")
    public void logEventBeforeOrderFacade(Object obj) {
        LOGGER.info("Class: " + obj.getClass().getName());
        try {
            LOGGER.info("Log method: " + obj.getClass().getMethod("processOrder", OrderDto.class, Long.class).getName());
        } catch ( NoSuchMethodException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @AfterThrowing("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEventAfterThrowingOrderFacade() {
        LOGGER.info("Method throws exception");
    }

    @AfterReturning("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEventAfterReturningOrderFacade() {
        LOGGER.info("Method works");
    }

    @Before("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))" +
            "&& args(theNumber) && target(obj)")
    public void logEvent(BigDecimal theNumber, Object obj) {
        LOGGER.info("Class: " + obj.getClass().getName() + ", args: " + theNumber);
    }

    @Around("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed: " + (end-begin) + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }


}