package com.polovyi.ivan.tutorials.v10;

import com.google.inject.Inject;

public class BillingService {

    private ReportGenerator reportGenerator;
    private ThirdPartyEmailAPIClient apiClient;


    @Inject
    public BillingService(@XMLReportImpl ReportGenerator reportGenerator, ThirdPartyEmailAPIClient apiClient) {
        this.reportGenerator = reportGenerator;
        this.apiClient = apiClient;
    }

    public void generateCustomerReport() {
        System.out.println("apiClient = " + apiClient);
        String report = reportGenerator.generate();
        System.out.println("report = " + report);
        apiClient.sendEmail("fake-xml@email.com", report);
    }
}
