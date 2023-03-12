package com.polovyi.ivan.tutorials.v9;

import com.google.inject.Inject;

public class CustomerService {

    private ReportGenerator reportGenerator;
    private ThirdPartyEmailAPIClient apiClient;

    @Inject
    public CustomerService(@CSVReportImpl ReportGenerator reportGenerator, ThirdPartyEmailAPIClient apiClient) {
        this.reportGenerator = reportGenerator;
        this.apiClient = apiClient;
    }

    public void generateCustomerReport() {
        System.out.println("apiClient = " + apiClient);
        String report = reportGenerator.generate();
        System.out.println("report = " + report);
        apiClient.sendEmail("fake-csv@email.com", report);
    }
}
