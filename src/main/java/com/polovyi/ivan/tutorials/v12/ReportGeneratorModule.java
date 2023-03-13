package com.polovyi.ivan.tutorials.v12;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.ProvidesIntoMap;
import com.google.inject.name.Names;
import com.polovyi.ivan.tutorials.v12.ReportGenerator.ReportType;

public class ReportGeneratorModule extends AbstractModule {

    @Override
    protected void configure() {

        MapBinder<ReportType, ReportGenerator> reportGeneratorBinder =
                MapBinder.newMapBinder(binder(), ReportType.class, ReportGenerator.class);

        reportGeneratorBinder.addBinding(ReportType.CSV).to(CSVReportGenerator.class);

        bind(CustomerDAO.class).in(Scopes.SINGLETON);
        bind(String.class).annotatedWith(Names.named("apiKey")).toInstance("third-party-api-key");
        bind(ThirdPartyEmailAPIClient.class).toProvider(ThirdPartyEmailAPIClientProvider.class)
                .in(Scopes.SINGLETON);
        bind(RetryQueueClient.class).toProvider(RetryQueueClientProvider.class)
                .in(Scopes.SINGLETON);
    }

    //@StringMapKey("XML") - if a string is used for the key
    @ProvidesIntoMapKey(ReportType.XML)
    @ProvidesIntoMap
    public ReportGenerator instantiateXMLReportGenerator(XMLReportGenerator generator) {
        return generator;
    }
}
