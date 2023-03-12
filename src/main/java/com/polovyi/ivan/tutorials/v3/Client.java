package com.polovyi.ivan.tutorials.v3;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class Client {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ReportGeneratorModule());
        ReportGenerator reportGenerator = injector.getInstance(CSVReportGenerator.class);
        CustomerService customerServiceForCSV = new CustomerService(reportGenerator);
        customerServiceForCSV.generateCustomerReport();
    }
}
