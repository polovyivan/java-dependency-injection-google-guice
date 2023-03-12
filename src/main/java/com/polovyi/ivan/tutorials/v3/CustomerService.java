package com.polovyi.ivan.tutorials.v3;

public class CustomerService {

    private ReportGenerator reportGenerator;

    public CustomerService(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void generateCustomerReport() {
        String report = reportGenerator.generate();
        System.out.println("report = " + report);
    }
}
