package com.example.exojt.payload.response;

import com.example.exojt.models.TokenSession;

public class UserContext {
    private static final ThreadLocal<TokenSession> context = new ThreadLocal<>();

    public static void setUserContext (TokenSession tokenSession){
         context.set(tokenSession);
    }

    public static TokenSession getUserContext(){
        return context.get();
    }

    public static String getUserId(){
        TokenSession session = context.get();
        return session.getUserId();
    }

    public static String getEmail(){
        TokenSession session = context.get();
        return session.getEmail();
    }
}
