package com.restapi.controller;

import com.restapi.domain.Customer;
import com.restapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/restapi")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getString")
    public ResponseEntity<String> getString() {
        return new ResponseEntity<>("Hello Angad", HttpStatus.OK);
    }

    @GetMapping("/getJsonAsOutput")
    public ResponseEntity<Object> getJsonAsOutput() {
        Map<String, String> map = new HashMap<>();
        map.put("Name", "Angad Yadav");
        map.put("Age", "34");
        map.put("State", "Iowa");
        map.put("Country", "United State Of America");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer result = customerService.save(customer);
        if (result == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<List<Customer>> getCustomerList() {
        return new ResponseEntity<>(customerService.findAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable Long id) {
        Optional<Customer> result = customerService.findById(id);
        return result.map(customer ->
                        new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerByID(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        System.out.println("record deleted : " + id);
        return new ResponseEntity<>("Customer Deleted : " + id, HttpStatus.OK);
    }

    @PostMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomerPut(@Validated @RequestBody Customer customer) {
        Customer result = customerService.save(customer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
