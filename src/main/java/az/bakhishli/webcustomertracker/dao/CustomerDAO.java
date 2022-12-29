package az.bakhishli.webcustomertracker.dao;

import az.bakhishli.webcustomertracker.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    void delete(int customerId);
}
