package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * packageName    : hello.hellospring.aop
 * fileName       : TimeTraceAop
 * author         : asdfz
 * date           : 2023-06-19
 * description    : AOP
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-19        asdfz       최초 생성
 */

//aop사용하기 위한 어노테이션
@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long satrt = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();


        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - satrt;

            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }


    }

}
