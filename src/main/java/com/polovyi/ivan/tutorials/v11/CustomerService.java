package com.polovyi.ivan.tutorials.v11;

import com.google.inject.Inject;
import com.polovyi.ivan.tutorials.v11.ReportGenerator.ReportType;

public class CustomerService {

    private ThirdPartyEmailAPIClient apiClient;
    private ReportGeneratorFactory factory;

    @Inject
    public CustomerService(ThirdPartyEmailAPIClient apiClient,
            ReportGeneratorFactory factory) {
        this.apiClient = apiClient;
        this.factory = factory;
    }

    public void generateCustomerReport() {
        System.out.println("apiClient = " + apiClient);
        String report = factory.getReportGenerator(ReportType.CSV).generate();
        System.out.println("report = " + report);
        apiClient.sendEmail("fake-csv@email.com", report);
    }
}
