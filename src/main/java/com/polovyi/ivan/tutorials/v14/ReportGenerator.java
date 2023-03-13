package com.polovyi.ivan.tutorials.v14;

public interface ReportGenerator {

    String generate();

    ReportType getReportType();

    enum ReportType {
        CSV,
        XML
    }
}
