package com.polovyi.ivan.tutorials.v12;

import com.google.inject.Inject;
import com.polovyi.ivan.tutorials.v12.ReportGenerator.ReportType;

public class CustomerService {

    private ThirdPartyEmailAPIClient apiClient;
    private ReportGeneratorFactory factory;
    private RetryQueueClientProvider retryQueueClientProvider;

    @Inject
    public CustomerService(ThirdPartyEmailAPIClient apiClient,
            ReportGeneratorFactory factory, RetryQueueClientProvider retryQueueClientProvider) {
        this.apiClient = apiClient;
        this.factory = factory;
        this.retryQueueClientProvider = retryQueueClientProvider;
    }

    public void generateCustomerReport() {
        System.out.println("apiClient = " + apiClient);
        String report = factory.getReportGenerator(ReportType.CSV).generate();
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
