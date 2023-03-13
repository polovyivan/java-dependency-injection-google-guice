package com.polovyi.ivan.tutorials.v15;

public interface Logger {

    <T> void log(Class<T> clazz, String message);
}
