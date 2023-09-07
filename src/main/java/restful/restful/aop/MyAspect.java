package restful.restful.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class MyAspect {

//    @Before(value = "execution(* restful.restful.EmployeeApi.*(..))")
//    public void beforeAdvice(JoinPoint joinPoint){
//        System.out.println("Requested To"+" "+ joinPoint.getSignature()+ "Started At" + new Date());
//    }
//
//    @After(value = "execution(* restful.restful.EmployeeService.getEmployee(..))")
//    public void afterAdvice(JoinPoint joinPoint){
//        System.out.println("Requested To"+" "+ joinPoint.getSignature()+ "Ended At" + new Date());
//    }
}
