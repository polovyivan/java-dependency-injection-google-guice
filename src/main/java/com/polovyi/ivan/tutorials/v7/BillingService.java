package com.polovyi.ivan.tutorials.v7;

import com.google.inject.Inject;

public class BillingService {

    private ReportGenerator reportGenerator;

    @Inject
    public BillingService(@XMLReportImpl ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void generateCustomerReport() {
        String report = reportGenerator.generate();
        System.out.println("report = " + report);
    }
}
