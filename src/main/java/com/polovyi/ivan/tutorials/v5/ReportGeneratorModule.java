package com.polovyi.ivan.tutorials.v5;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ReportGeneratorModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(ReportGenerator.class)
                .annotatedWith(Names.named("CSVReportImpl")).to(CSVReportGenerator.class);
        bind(ReportGenerator.class)
                .annotatedWith(Names.named("XMLReportImpl")).to(XMLReportGenerator.class);
    }
}
