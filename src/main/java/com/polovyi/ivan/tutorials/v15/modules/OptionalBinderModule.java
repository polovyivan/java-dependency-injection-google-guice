package com.polovyi.ivan.tutorials.v15.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.multibindings.OptionalBinder;
import com.polovyi.ivan.tutorials.v15.CustomLogger;
import com.polovyi.ivan.tutorials.v15.Logger;

public class OptionalBinderModule extends AbstractModule {

    @Override
    protected void configure() {
        OptionalBinder.newOptionalBinder(binder(), CustomLogger.class);
    }

    @Singleton
    @Provides
    public Logger provideLogger(CustomLogger logger) {
        return logger;
    }
}
