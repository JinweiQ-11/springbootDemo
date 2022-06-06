package org.example.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.entity.Project;
import org.example.utils.ProjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
//import reactor.ipc.netty.http.server.HttpServerRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletRequest;
import java.util.HashMap;

@Aspect
@Component
public class AopLog {
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    //定义切点
    @Pointcut("execution(public * org.example..AddController.*(..))")
    public void aopWebLogz() {
    }

//    @Before("aopWebLogz()")
//    public void doBefore(JoinPoint joinPoint) {
//        startTime.set(System.currentTimeMillis());
//        //接受请求
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        logger.info("------------- 开始 -------------");
//        //记录请求内容
//        logger.info("URL" + request.getRequestURL().toString());
//        logger.info("method" + request.getMethod());
//        logger.info("ip" + request.getRemoteAddr());
//        //分别获取类名和方法名
//        logger.info("类的方法" + joinPoint.getSignature().getDeclaringTypeName() + joinPoint.getSignature().getName());
//        logger.info("请求参数" + request.getQueryString());
//        logger.info("------------- 获取结束 -------------");
//    }


//    @AfterReturning(pointcut = "aopWebLogz()", returning = "reObject")
//    public void doAftere(Object reObject) {
//        logger.info("应答值" + reObject.toString());
//        Long time = System.currentTimeMillis() - startTime.get();
//        logger.info("费时" + time);
//    }

    @Around(value = "aopWebLogz()")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("----- 开始执行 {}.{}-----",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());

        // 记录开始时间
        final long begin = System.currentTimeMillis();

        // 执行目标 service
        final HashMap result = (HashMap) joinPoint.proceed();

        // 记录结束时间
        final long end = System.currentTimeMillis();
        final long takeTime = end - begin;
        result.put("elapsed",String.format("%s ms",takeTime));
        return result;

    }
}
