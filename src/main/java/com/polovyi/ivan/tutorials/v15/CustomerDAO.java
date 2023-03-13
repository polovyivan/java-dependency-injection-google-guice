package com.polovyi.ivan.tutorials.v15;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.time.LocalDate;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

public class CustomerDAO {

    private static final String URL = "http://localhost";
    private String url = URL;

    @Inject(optional = true)
    public void setUrl(@Named("DatabaseUrl") String url) {
        this.url = url;
    }


    public Set<Customer> findCustomers() {
        System.out.println("Fetching data from DB using url = " + url);
        return Set.of(
                new Customer("1", "Customer1", LocalDate.now()),
                new Customer("2", "Customer2", LocalDate.now().minusDays(1))

        );
    }

    @Data
    @AllArgsConstructor
    public static class Customer {

        private String id;
        private String customerName;
        private LocalDate createdAt;
    }
}
