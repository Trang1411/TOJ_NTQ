package com.example.exojt.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("execution(* com.example.exojt.controller.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (servletRequestAttributes == null) {
                return null;
            }
            HttpServletRequest request = servletRequestAttributes.getRequest();
            // Proceed timer
            long startTime = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long processTime = System.currentTimeMillis() - startTime;

            log.info("Exit: getDeclaringTypeName = {} \n" +
                            "api name = {}.\n" +
                            "method = {} \n" +
                            "url = {} \n" +
                            "processtime = {}\n" +
                            "result = {}",
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), // get name api
                    getMethodAPI(request),
                    getURLRequest(request),
                    processTime,
                    result);
            if (log.isDebugEnabled()) {

            /*LogsResponse response = LogsResponse.builder()
                    .method(method)
                    .nameMethod(apiName)
                    .processTime(processTime)
                    .url(urlRequest)
                    .build();*/
            }


            return result;
        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()",
                    Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName());
            throw e;
        }
    }

    private String getURLRequest(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getRequestURL().toString();
    }

    private String getMethodAPI(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getMethod();
    }

    private String getAPIName(ProceedingJoinPoint joinPoint) {
        return joinPoint.getSignature().getName();
    }
}
