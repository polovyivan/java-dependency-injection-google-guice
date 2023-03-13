package com.polovyi.ivan.tutorials.v13;

public interface Logger {

    <T> void log(Class<T> clazz, String message);
}
