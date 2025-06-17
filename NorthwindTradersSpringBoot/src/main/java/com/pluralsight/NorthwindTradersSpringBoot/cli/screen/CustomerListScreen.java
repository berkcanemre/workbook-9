package com.pluralsight.NorthwindTradersSpringBoot.cli.screen;

import com.pluralsight.NorthwindTradersSpringBoot.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerListScreen {
    public void displayAllCustomers(List<Customer> customers) {
        System.out.println("\n------------\n");
        customers.forEach(System.out::println);
    }
}