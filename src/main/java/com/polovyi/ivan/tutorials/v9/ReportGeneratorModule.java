package com.polovyi.ivan.tutorials.v9;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

public class ReportGeneratorModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(ReportGenerator.class)
                .annotatedWith(CSVReportImpl.class).to(CSVReportGenerator.class);
        bind(ReportGenerator.class)
                .annotatedWith(XMLReportImpl.class).to(XMLReportGenerator.class);
        bind(CustomerDAO.class).in(Scopes.SINGLETON);
        bind(String.class).annotatedWith(Names.named("apiKey")).toInstance("third-party-api-key");
        bind(ThirdPartyEmailAPIClient.class).toProvider(ThirdPartyEmailAPIClientProvider.class)
                .in(Scopes.SINGLETON);
    }
}
