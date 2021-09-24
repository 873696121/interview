package aop.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/***********************************************************                                          *
 * Time: 2021/9/24
 * Author: HuHong
 * Desc:
 ***********************************************************/

@Aspect
@Component
public class MyLog {

    private Logger logger = LoggerFactory.getLogger(MyLog.class);

    @Pointcut(value = "execution(* aop.controller.*.*(..))")
    public void myPointcut(){

    }


    @Around("myPointcut()")
    public Object myLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().toString();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();

        ObjectMapper objectMapper = new ObjectMapper();

        logger.info("调用前： classname: " + className + " methodname: " + methodName + " args: " + objectMapper.writeValueAsString(args));

        Object obj = proceedingJoinPoint.proceed();

        logger.info("调用后： classname: " + className + " methodname: " + methodName + " return: " + objectMapper.writeValueAsString(obj));
        return obj;
    }



}
