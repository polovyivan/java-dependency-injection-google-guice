package com.polovyi.ivan.tutorials.v11;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.multibindings.ProvidesIntoSet;
import com.google.inject.name.Names;

public class ReportGeneratorModule extends AbstractModule {

    @Override
    protected void configure() {

        Multibinder<ReportGenerator> reportGeneratorMultibinder = Multibinder.newSetBinder(binder(), ReportGenerator.class);
        reportGeneratorMultibinder.addBinding().to(CSVReportGenerator.class);

        bind(CustomerDAO.class).in(Scopes.SINGLETON);
        bind(String.class).annotatedWith(Names.named("apiKey")).toInstance("third-party-api-key");
        bind(ThirdPartyEmailAPIClient.class).toProvider(ThirdPartyEmailAPIClientProvider.class)
                .in(Scopes.SINGLETON);
        bind(RetryQueueClient.class).toProvider(RetryQueueClientProvider.class)
                .in(Scopes.SINGLETON);
    }

    @ProvidesIntoSet
    public ReportGenerator instantiateXMLReportGenerator(XMLReportGenerator generator) {
        return generator;
    }
}
