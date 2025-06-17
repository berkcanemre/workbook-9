package com.pluralsight.NorthwindTradersSpringBoot.cli.screen;

import org.springframework.stereotype.Component;

@Component
public class MenuScreen {
    public void displayMenu() {
        System.out.println("--Northwind Customers--");
        System.out.println("View All Customers (1)");
        System.out.println("Add a Customer     (2)");
        System.out.println("Delete a Customer  (3)");
        System.out.println("Exit           (0)");
        System.out.print("Enter an Option: ");
    }
}
