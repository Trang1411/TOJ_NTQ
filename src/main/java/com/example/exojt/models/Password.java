package com.example.exojt.models;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class Password {
    public static String generateRandomPassword()
    {
        SecureRandom random = new SecureRandom();
        return random.ints(8, 10, 122 + 1)
                .mapToObj(i -> String.valueOf((char)i))
                .collect(Collectors.joining());
    }

}
