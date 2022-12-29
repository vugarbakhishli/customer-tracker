package az.bakhishli.webcustomertracker.service;

import az.bakhishli.webcustomertracker.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    void delete(int customerId);
}
