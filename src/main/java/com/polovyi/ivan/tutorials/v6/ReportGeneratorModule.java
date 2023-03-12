package com.polovyi.ivan.tutorials.v6;

import com.google.inject.AbstractModule;

public class ReportGeneratorModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(ReportGenerator.class)
                .annotatedWith(CSVReportImpl.class).to(CSVReportGenerator.class);
        bind(ReportGenerator.class)
                .annotatedWith(XMLReportImpl.class).to(XMLReportGenerator.class);
    }
}
