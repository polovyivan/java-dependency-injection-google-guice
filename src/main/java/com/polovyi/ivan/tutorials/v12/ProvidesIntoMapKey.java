package com.polovyi.ivan.tutorials.v12;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.google.inject.multibindings.MapKey;
import java.lang.annotation.Retention;

@MapKey()
@Retention(RUNTIME)
public @interface ProvidesIntoMapKey {
    ReportGenerator.ReportType value();
}
