package com.polovyi.ivan.tutorials.v13;

import java.time.LocalDateTime;

public class CustomLogger implements Logger {

    public <T> void log(Class<T> clazz, String message) {
        System.out.println("[" + LocalDateTime.now() + "]-[" + clazz.getName() + "]-[" + message + "]");
    }
}
