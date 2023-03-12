package com.polovyi.ivan.tutorials.v11;

import com.google.inject.Inject;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = @Inject)
public class XMLReportGenerator implements ReportGenerator {

    private CustomerDAO dao;

    @Override
    public ReportType getReportType() {
        return ReportType.XML;
    }

    @Override
    public String generate() {
        System.out.println("dao = " + dao);
        return "<customers>\r\n" + dao.findCustomers().stream()
                .map(customer ->
                        "<id>" + customer.getId() + "<id/>\r\n"
                                + "<customerName>" + customer.getCustomerName() + "<customer/>\r\n"
                                + "<createdAt>" + customer.getCreatedAt().toString() + "<createdAt/>\r\n"
                ).collect(Collectors.joining("", "<customer>\r\n", "<customer/>\r\n")) +
                " <customers/>";
    }

}
