package com.polovyi.ivan.tutorials.v10;

import com.google.inject.Inject;

public class CustomerService {

    private ReportGenerator reportGenerator;
    private ThirdPartyEmailAPIClient apiClient;

    private RetryQueueClientProvider retryQueueClientProvider;

    @Inject
    public CustomerService(@CSVReportImpl ReportGenerator reportGenerator, ThirdPartyEmailAPIClient apiClient,
            RetryQueueClientProvider retryQueueClientProvider) {
        this.reportGenerator = reportGenerator;
        this.apiClient = apiClient;
        this.retryQueueClientProvider = retryQueueClientProvider;
    }

    public void generateCustomerReport() {
        System.out.println("apiClient = " + apiClient);
        String report = reportGenerator.generate();
        System.out.println("report = " + report);
        try {
            //   if (1 == 1) {
            //      throw new RuntimeException();
            //  }
            apiClient.sendEmail("fake-csv@email.com", report);
        } catch (Exception e) {
            System.out.println("error = " + e);
            retryQueueClientProvider.get().send("Error while trying to send a report: " + report);
        }
    }
}
