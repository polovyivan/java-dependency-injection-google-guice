package com.polovyi.ivan.tutorials.v14;

public interface Logger {

    <T> void log(Class<T> clazz, String message);
}
