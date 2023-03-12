package com.polovyi.ivan.tutorials.v1;

public class Client {

    public static void main(String[] args) {
        CSVReportGenerator csvReportGenerator = new CSVReportGenerator();
        CustomerService customerService = new CustomerService(csvReportGenerator);
        customerService.generateCustomerReport();
    }
}
