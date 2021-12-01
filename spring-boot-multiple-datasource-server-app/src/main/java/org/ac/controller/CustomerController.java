package org.ac.controller;

import org.ac.entities.Customer;
import org.ac.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customers")
@CrossOrigin(origins = "http://localhost:8090")
public class CustomerController {

    @Autowired
    public CustomerServiceImpl customerService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> fetchAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeCustomerData(@PathVariable(name = "id") String id) {
        customerService.removeCustomerData(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> modifyCustomer(@PathVariable(name = "id") String id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.modifyCustomer(id, customer));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> saveCustomerData(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomerData(customer));
    }
}
