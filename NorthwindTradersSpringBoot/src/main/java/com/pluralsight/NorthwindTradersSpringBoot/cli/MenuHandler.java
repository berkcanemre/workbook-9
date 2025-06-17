package com.pluralsight.NorthwindTradersSpringBoot.cli;

import com.pluralsight.NorthwindTradersSpringBoot.cli.screen.CustomerListScreen;
import com.pluralsight.NorthwindTradersSpringBoot.cli.screen.MenuScreen;
import com.pluralsight.NorthwindTradersSpringBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuHandler {

    private final MenuScreen menuScreen;
    private final CustomerListScreen customerListScreen;
    private final CustomerService customerService;
    private final Utils utils;

    @Autowired
    public MenuHandler(MenuScreen menuScreen,
                       CustomerListScreen customerListScreen,
                       CustomerService customerService,
                       Utils utils) {
        this.menuScreen = menuScreen;
        this.customerListScreen = customerListScreen;
        this.customerService = customerService;
        this.utils = utils;
    }

    public void showMainMenu() {
        menuScreen.displayMenu();
        String option = utils.getUserInput();
        handleUserOption(option);
    }

    private void handleUserOption(String option) {
        switch (option) {
            case "0" -> exitScreen();
            case "1" -> showAllCustomers();
            case "2" -> System.out.println("@Todo - add customers");
            case "3" -> System.out.println("@Todo - delete customers");
            default -> {
                System.out.println("Invalid option. Please try again.");
                showMainMenu();
            }
        }
    }

    private void showAllCustomers() {
        customerListScreen.displayAllCustomers(customerService.getAllCustomers());
        utils.pauseBriefly();
        showMainMenu();
    }



    private void exitScreen() {
        System.out.println("Thank you for visiting the Northwind Data Service");
        System.out.println("System Exited");
        System.exit(0);
    }

}