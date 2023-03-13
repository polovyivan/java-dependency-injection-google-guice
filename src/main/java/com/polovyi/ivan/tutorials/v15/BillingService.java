package com.polovyi.ivan.tutorials.v15;

import com.google.inject.Inject;
import com.polovyi.ivan.tutorials.v15.ReportGenerator.ReportType;
import java.util.Optional;

public class BillingService {

    private ThirdPartyEmailAPIClient apiClient;
    private ReportGeneratorFactory factory;
    private Optional<CustomLogger> logger;


    @Inject
    public BillingService(ThirdPartyEmailAPIClient apiClient,
            ReportGeneratorFactory factory,
            Optional<CustomLogger> logger) {
        this.apiClient = apiClient;
        this.factory = factory;
        this.logger = logger;
    }
    public void generateCustomerReport() {
        logger.ifPresent(log -> log.log(this.getClass(), "apiClient = " + apiClient));
        String report = factory.getReportGenerator(ReportType.XML).generate();
        logger.ifPresent(log -> log.log(this.getClass(), "report = " + report));
        apiClient.sendEmail("fake-xml@email.com", report);
    }
}
