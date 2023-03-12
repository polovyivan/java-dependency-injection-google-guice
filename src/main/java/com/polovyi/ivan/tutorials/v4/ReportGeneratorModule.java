package com.polovyi.ivan.tutorials.v4;

import com.google.inject.AbstractModule;

public class ReportGeneratorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ReportGenerator.class).to(CSVReportGenerator.class);
    }
}
