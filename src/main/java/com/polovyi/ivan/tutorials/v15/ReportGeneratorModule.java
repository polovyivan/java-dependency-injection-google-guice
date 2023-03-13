package com.polovyi.ivan.tutorials.v15;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

public class ReportGeneratorModule extends AbstractModule {

    @Override
    protected void configure() {

        install(new CollectionBinderModule());

        bind(CustomerDAO.class).in(Scopes.SINGLETON);
        bind(String.class).annotatedWith(Names.named("apiKey")).toInstance("third-party-api-key");
        bind(ThirdPartyEmailAPIClient.class).toProvider(ThirdPartyEmailAPIClientProvider.class)
                .in(Scopes.SINGLETON);
        bind(RetryQueueClient.class).toProvider(RetryQueueClientProvider.class)
                .in(Scopes.SINGLETON);
        bind(String.class).annotatedWith(Names.named("DatabaseUrl")).toInstance("http://url-from-configuration");
    }
}
