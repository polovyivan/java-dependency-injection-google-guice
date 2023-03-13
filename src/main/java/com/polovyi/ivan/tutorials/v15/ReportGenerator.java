package com.polovyi.ivan.tutorials.v15;

public interface ReportGenerator {

    String generate();

    ReportType getReportType();

    enum ReportType {
        CSV,
        XML
    }
}
