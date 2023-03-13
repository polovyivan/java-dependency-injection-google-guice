package com.polovyi.ivan.tutorials.v12;

public interface ReportGenerator {

    String generate();

    ReportType getReportType();

    enum ReportType {
        CSV,
        XML
    }
}
