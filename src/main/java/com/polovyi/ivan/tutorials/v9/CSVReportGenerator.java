package com.polovyi.ivan.tutorials.v9;

import com.google.inject.Inject;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = @Inject)
public class CSVReportGenerator implements ReportGenerator {

    private CustomerDAO dao;

    @Override
    public String generate() {
        System.out.println("dao = " + dao);
        return dao.findCustomers().stream()
                .map(customer -> Stream.of(customer.getId(),
                                customer.getCustomerName(),
                                customer.getCreatedAt().toString())
                        .collect(Collectors.joining(";", "", "\r\n")))
                .collect(Collectors.joining());

    }
}
