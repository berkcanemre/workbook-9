package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

@Component
public class CustomerDAOJDBCImpl implements CustomerDAO {
    private List<Customer> customers;
    private DataSource dataSource;

    @Autowired
    public CustomerDAOJDBCImpl(DataSource dataSource) {
        this.customers = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public List<Customer> getAll() {
        this.customers.clear();
        String sql = "SELECT CustomerID, CompanyName, ContactName, ContactTitle, " +
                "Address, City, Region, PostalCode, Country, Phone, Fax FROM Customers;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while (rows.next()) {
                this.customers.add(new Customer(
                        rows.getString("CustomerID"),
                        rows.getString("CompanyName"),
                        rows.getString("ContactName"),
                        rows.getString("ContactTitle"),
                        rows.getString("Address"),
                        rows.getString("City"),
                        rows.getString("Region"),
                        rows.getString("PostalCode"),
                        rows.getString("Country"),
                        rows.getString("Phone"),
                        rows.getString("Fax")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.customers;
    }

    @Override
    public List<Customer> getByCompanyName() {
        // TODO: Implement this method
        return null;
    }

    @Override
    public List<Customer> getByContactName() {
        // TODO: Implement this method
        return null;
    }

    @Override
    public List<Customer> getByAddress() {
        // TODO: Implement this method
        return null;
    }

    @Override
    public Customer getByCustomerID() {
        // TODO: Implement this method
        return null;
    }

    @Override
    public void delete() {
        // TODO: Implement this method
    }

    @Override
    public void add(Customer customer) {
        // For now just add to local list (implement DB insert later)
        this.customers.add(customer);
    }
}
