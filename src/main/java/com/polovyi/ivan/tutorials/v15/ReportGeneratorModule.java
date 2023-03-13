package com.polovyi.ivan.tutorials.v15;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.OptionalBinder;
import com.google.inject.name.Names;
import com.polovyi.ivan.tutorials.v15.ReportGenerator.ReportType;

public class ReportGeneratorModule extends AbstractModule {

    @Override
    protected void configure() {

        MapBinder<ReportType, ReportGenerator> reportGeneratorBinder =
                MapBinder.newMapBinder(binder(), ReportType.class, ReportGenerator.class);

        reportGeneratorBinder.addBinding(ReportType.CSV).to(CSVReportGenerator.class);
        reportGeneratorBinder.addBinding(ReportType.XML).to(XMLReportGenerator.class);

        bind(CustomerDAO.class).in(Scopes.SINGLETON);

        bind(String.class).annotatedWith(Names.named("apiKey")).toInstance("third-party-api-key");
        bind(ThirdPartyEmailAPIClient.class).toProvider(ThirdPartyEmailAPIClientProvider.class)
                .in(Scopes.SINGLETON);
        bind(RetryQueueClient.class).toProvider(RetryQueueClientProvider.class)
                .in(Scopes.SINGLETON);
        OptionalBinder.newOptionalBinder(binder(), CustomLogger.class);
        bind(String.class).annotatedWith(Names.named("DatabaseUrl")).toInstance("http://url-from-configuration");

    }

    @Singleton
    @Provides
    public Logger provideLogger(CustomLogger logger) {
        return logger;
    }
}
