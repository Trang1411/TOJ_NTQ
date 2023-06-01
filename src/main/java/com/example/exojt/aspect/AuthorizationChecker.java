package com.example.exojt.aspect;

import com.example.MappingCustom.AuthorizationAPI;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Component
public class AuthorizationChecker {

    @Before("execution(* com.example.exojt.controller.*.*(..))")
    public void checkAuthorization(JoinPoint joinPoint) throws NoSuchMethodException {

        //get infor api
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Annotation annotation = method.getAnnotation(AuthorizationAPI.class);
        if (annotation == null) {
            return;
        }
        System.out.println("======== 1111111111 =====================");
        Method[] methods = annotation.getClass().getDeclaredMethods();
        Method roles = null;
        for (Method x : methods) {
            if (x.getName().equals("roles")) {
                roles = x;
                break;
            }
        }
        if (roles == null) {
            return;
        }

        try {
            String[] values = (String[]) roles.invoke(annotation, (String[]) new String[]{});
            for (String s : values) {
                System.out.println("===== 222 =========== " + s);

            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
