package com.polovyi.ivan.tutorials.v4;

import com.google.inject.Inject;

public class CustomerService {

    private ReportGenerator reportGenerator;

    @Inject
    public CustomerService(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void generateCustomerReport() {
        String report = reportGenerator.generate();
        System.out.println("report = " + report);
    }
}
