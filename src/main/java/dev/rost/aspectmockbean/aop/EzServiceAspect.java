package dev.rost.aspectmockbean.aop;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
class EzServiceAspect {

    @SneakyThrows
    @Around("bean(ezService) && execution(* ezMove())")
    void ezMove(ProceedingJoinPoint pjp) {
        System.out.println("@Around: EzServiceAspect#ezMove");
        pjp.proceed();
    }
}
