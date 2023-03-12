package com.polovyi.ivan.tutorials.v5;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class CustomerService {

    private ReportGenerator reportGenerator;

    @Inject
    public CustomerService(@Named("CSVReportImpl") ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void generateCustomerReport() {
        String report = reportGenerator.generate();
        System.out.println("report = " + report);
    }
}
