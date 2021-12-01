package org.ac.service;

import org.ac.entities.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomer();

    Customer getCustomerById(String id);

    void removeCustomerData(String id);

    Customer modifyCustomer(String id, Customer customer);

    Customer saveCustomerData(Customer customer) ;
}
