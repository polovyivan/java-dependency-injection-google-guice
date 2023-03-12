package com.polovyi.ivan.tutorials.v11;

public interface ReportGenerator {

    String generate();

    ReportType getReportType();

    enum ReportType {
        CSV,
        XML
    }
}
