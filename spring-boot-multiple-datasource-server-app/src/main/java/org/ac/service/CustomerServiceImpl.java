package org.ac.service;

import org.ac.entities.Customer;
import org.ac.exception.NoRecordsFoundException;
import org.ac.repositories.mongo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(String id) {
        if (customerRepository.existsById(id)) {
            return customerRepository.findById(id).get();
        } else {
            throw new NoRecordsFoundException("Records for the supplied Id " + id + " does not exist.");
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void removeCustomerData(String id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new NoRecordsFoundException("Records for the supplied Id " + id + " does not exist.");
        }
    }

    @Override
    @Transactional(readOnly = false)
    public Customer modifyCustomer(String id, Customer customer) {
        if (customerRepository.existsById(id) && customer != null) {
            return customerRepository.save(customer);
        } else {
            throw new NoRecordsFoundException("Records for the supplied Id " + id + " does not exist.");
        }
    }

    @Override
    @Transactional(readOnly = false)
    public Customer saveCustomerData(Customer customer) {
        if (customer != null) {
            return customerRepository.save(customer);
        } else {
            throw new NoRecordsFoundException("Please supply the valid data");
        }
    }

}
