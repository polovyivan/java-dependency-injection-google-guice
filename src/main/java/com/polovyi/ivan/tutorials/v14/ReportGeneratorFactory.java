package com.polovyi.ivan.tutorials.v14;

import com.google.inject.Inject;
import com.polovyi.ivan.tutorials.v14.ReportGenerator.ReportType;
import java.util.Map;
import java.util.Optional;

public class ReportGeneratorFactory {

    private final Map<ReportType, ReportGenerator> reportGenerators;

    @Inject
    public ReportGeneratorFactory(Map<ReportType, ReportGenerator> reportGenerators) {
        this.reportGenerators = reportGenerators;
    }

    public ReportGenerator getReportGenerator(ReportType type) {
        return Optional.ofNullable(reportGenerators.get(type))
                .orElseThrow();
    }
}
