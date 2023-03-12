package com.polovyi.ivan.tutorials.v2;

public class Client {

    public static void main(String[] args) {
        ReportGenerator reportGenerator = new CSVReportGenerator();
        CustomerService customerService = new CustomerService(reportGenerator);
        customerService.generateCustomerReport();
    }
}
