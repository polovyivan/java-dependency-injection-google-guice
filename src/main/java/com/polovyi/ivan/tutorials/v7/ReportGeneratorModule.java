package com.polovyi.ivan.tutorials.v7;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class ReportGeneratorModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(ReportGenerator.class)
                .annotatedWith(CSVReportImpl.class).to(CSVReportGenerator.class);
        bind(ReportGenerator.class)
                .annotatedWith(XMLReportImpl.class).to(XMLReportGenerator.class);
        bind(CustomerDAO.class).in(Scopes.SINGLETON);
        // bind(CustomerDAO.class).to(SomeImplementation.class).in(Scopes.SINGLETON);
    }
}
