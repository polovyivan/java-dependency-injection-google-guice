package com.polovyi.ivan.tutorials.v1;

public class CustomerService {

    private CSVReportGenerator csvReportGenerator;

    public CustomerService(CSVReportGenerator csvReportGenerator) {
        this.csvReportGenerator = csvReportGenerator;
    }

    public void generateCustomerReport() {
        String report = csvReportGenerator.generate();
        System.out.println("report = " + report);
    }
}
