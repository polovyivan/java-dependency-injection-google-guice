package com.polovyi.ivan.tutorials.v13;

public interface ReportGenerator {

    String generate();

    ReportType getReportType();

    enum ReportType {
        CSV,
        XML
    }
}
