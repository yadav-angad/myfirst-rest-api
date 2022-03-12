package com.restapi.service;

import com.restapi.domain.Customer;
import com.restapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        System.out.println("Hello : " + customer.getFirstName());
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomerById(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void delete(Customer object) {
        customerRepository.delete(object);
    }
}
