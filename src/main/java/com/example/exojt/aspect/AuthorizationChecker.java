package com.example.exojt.aspect;

import com.example.MappingCustom.AuthorizationAPI;
import com.example.exojt.models.TokenSession;
import com.example.exojt.payload.response.UserContext;
import com.example.exojt.security.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Aspect
@Component
@AllArgsConstructor
public class AuthorizationChecker {
    private final JwtUtils jwtUtils;

    @Before("execution(* com.example.exojt.controller.*.*(..))")
    public void checkAuthorization(JoinPoint joinPoint) throws NoSuchMethodException {

        //get infor api
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Annotation annotation = method.getAnnotation(AuthorizationAPI.class);

        if (annotation == null) {
            return;
        }
        Method[] methods = annotation.getClass().getDeclaredMethods();

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            throw new RuntimeException("--------null-------");
        }
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String token = request.getHeader("Authorization");
        TokenSession tokenSession = jwtUtils.parseToken(token);

        //Set User context
        UserContext.setUserContext(tokenSession);

        Method roles = null;
        for (Method role : methods) {
            if (role.getName().equals("roles")) {
                roles = role;
                break;
            }
        }
        if (roles == null) {
            throw new RuntimeException("PERMISSION DENIED !");
        }

        try {
            String[] values = (String[]) roles.invoke(annotation, (String[]) new String[]{});
            for (String s : values) {
                if (s.equals(tokenSession.getRole())) {
                    return;
                }

            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
