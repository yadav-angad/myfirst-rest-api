package com.restapi.service;

import com.restapi.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

    Customer save(Customer customer);

    Optional<Customer> findById(long id);

    List<Customer> findAllCustomer();

    void deleteCustomerById(long id);

    void delete(Customer object);
}
