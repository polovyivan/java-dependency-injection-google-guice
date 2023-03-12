package com.polovyi.ivan.tutorials.v8;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;

public class ReportGeneratorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CustomerDAO.class).in(Scopes.SINGLETON);
        bind(String.class).toInstance("third-party-api-key");
    }

    @Singleton
    @Provides
    public ThirdPartyEmailAPIClient instantiateClient(String apiKey) {
        return new ThirdPartyEmailAPIClient(apiKey);
    }


    @Provides
    @CSVReportImpl
    public ReportGenerator instantiateCSVReportGenerator(CSVReportGenerator generator) {
        return generator;
    }

    @Provides
    @XMLReportImpl
    public ReportGenerator instantiateXMLReportGenerator(XMLReportGenerator generator) {
        return generator;
    }
}
