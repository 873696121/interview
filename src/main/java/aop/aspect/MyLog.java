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

    private static int helloCnt = 0;

    private Logger logger = LoggerFactory.getLogger(MyLog.class);

    public static int getHelloCnt() {
        return helloCnt;
    }

    @Pointcut(value = "execution(* aop.controller.*.*(String, String))")
    public void myPointcut(){

    }

    @Pointcut(value = "execution(* aop.controller.*.*(String))")
    public void setHelloCnt(){

    }

    @Around("setHelloCnt()")
    public synchronized Object myCnt(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        logger.info("\n调用前: " + helloCnt);
        Object o = proceedingJoinPoint.proceed();
        helloCnt ++;
//        logger.info("调用后: " + helloCnt);
        return o;
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
