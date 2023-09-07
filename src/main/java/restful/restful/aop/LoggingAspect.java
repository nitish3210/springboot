package restful.restful.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Logging Application using AOP
 */
@Component
@Aspect
public class LoggingAspect {
    public static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * created point cut
     */
    @Pointcut(value = "execution(* restful.restful.*.*(..))")
    public void myPointCut(){

    }

    /**
     * logging important info at given pointcuts i.e myPointCut()
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
   @Around("myPointCut()")
   public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] array = joinPoint.getArgs();
        //this will log before method invoke
        log.info("Method Invoked "+ className+ " " + methodName + "()" + "Arguments " +  objectMapper.writeValueAsString(array));

        Object object = joinPoint.proceed();
       //this will log after method execution  completed
        log.info(className + " " + methodName + "()" + "Response " +  objectMapper.writeValueAsString(object));
        return object;
    }
}
