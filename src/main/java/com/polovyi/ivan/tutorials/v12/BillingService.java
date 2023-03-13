package com.polovyi.ivan.tutorials.v12;

import com.google.inject.Inject;
import com.polovyi.ivan.tutorials.v12.ReportGenerator.ReportType;

public class BillingService {

    private ThirdPartyEmailAPIClient apiClient;
    private ReportGeneratorFactory factory;

    @Inject
    public BillingService(ThirdPartyEmailAPIClient apiClient, ReportGeneratorFactory factory) {
        this.apiClient = apiClient;
        this.factory = factory;
    }

    public void generateCustomerReport() {
        System.out.println("apiClient = " + apiClient);
        String report = factory.getReportGenerator(ReportType.XML).generate();
        System.out.println("report = " + report);
        apiClient.sendEmail("fake-xml@email.com", report);
    }
}
