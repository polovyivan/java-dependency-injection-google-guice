package com.polovyi.ivan.tutorials.v15;

import com.google.inject.Inject;
import com.polovyi.ivan.tutorials.v15.ReportGenerator.ReportType;
import java.util.Optional;

public class CustomerService {

    private ThirdPartyEmailAPIClient apiClient;
    private ReportGeneratorFactory factory;
    private RetryQueueClientProvider retryQueueClientProvider;
    private Optional<CustomLogger> logger;

    @Inject
    public CustomerService(ThirdPartyEmailAPIClient apiClient,
            ReportGeneratorFactory factory,
            RetryQueueClientProvider retryQueueClientProvider,
            Optional<CustomLogger> logger) {
        this.apiClient = apiClient;
        this.factory = factory;
        this.retryQueueClientProvider = retryQueueClientProvider;
        this.logger = logger;
    }

    public void generateCustomerReport() {
        logger.ifPresent(log -> log.log(this.getClass(), "apiClient = " + apiClient));
        String report = factory.getReportGenerator(ReportType.CSV).generate();
        logger.ifPresent(log -> log.log(this.getClass(), "report = " + report));

        try {
            //   if (1 == 1) {
            //      throw new RuntimeException();
            //  }
            apiClient.sendEmail("fake-csv@email.com", report);
        } catch (Exception e) {
            logger.ifPresent(log -> log.log(this.getClass(), "error = " + e.getMessage()));
            retryQueueClientProvider.get().send("Error while trying to send a report: " + report);
        }
    }
}
