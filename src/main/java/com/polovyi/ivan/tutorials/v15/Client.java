package com.polovyi.ivan.tutorials.v15;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class Client {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ReportGeneratorModule(), new OptionalBinderModule());

        CustomerService customerServiceForCSV = injector.getInstance(CustomerService.class);
        customerServiceForCSV.generateCustomerReport();

        BillingService billingService = injector.getInstance(BillingService.class);
        billingService.generateCustomerReport();
    }
}
