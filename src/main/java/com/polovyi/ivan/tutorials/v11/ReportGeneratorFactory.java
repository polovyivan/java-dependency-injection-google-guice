package com.polovyi.ivan.tutorials.v11;

import com.google.inject.Inject;
import com.polovyi.ivan.tutorials.v11.ReportGenerator.ReportType;
import java.util.Set;

public class ReportGeneratorFactory {

    private final Set<ReportGenerator> reportGenerators;

    @Inject
    public ReportGeneratorFactory(Set<ReportGenerator> reportGenerators) {
        this.reportGenerators = reportGenerators;
    }

    public ReportGenerator getReportGenerator(ReportType type) {
        return reportGenerators.stream()
                .filter(generator -> generator.getReportType().equals(type))
                .findFirst().orElseThrow();
    }
}
