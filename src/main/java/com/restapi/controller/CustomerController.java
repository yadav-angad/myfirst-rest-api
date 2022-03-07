package com.restapi.controller;

import com.restapi.customer.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/restapi")
public class CustomerController {

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
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
        System.out.println("ID : " + customer.getId());
        System.out.println("Name : " + customer.getName());
        System.out.println("Age : " + customer.getAge());
        System.out.println("Address : " + customer.getAddress());
        return new ResponseEntity<>("Data saved !!!", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerByID(@PathVariable Long id) {
        System.out.println("record deleted : " + id);
        return new ResponseEntity<>("Customer Deleted : " + id, HttpStatus.OK);
    }

    //Patch is used to update/modify the entity
    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<String> updateCustomerPut(@PathVariable(value = "id") Long id,
                                                     @Validated @RequestBody Customer customer) {
        System.out.println("ID : " + id);
        System.out.println("Name : " + customer.getName());
        System.out.println("Age : " + customer.getAge());
        System.out.println("Address : " + customer.getAddress());
        return new ResponseEntity<>("Customer Updated : " + id, HttpStatus.OK);
    }

    //Patch applies partial update to the entity
    @PatchMapping("/updateCustomer/{id}")
    public ResponseEntity<String> updateCustomerPatch(@PathVariable(value = "id") Long id,
                                                      @Validated @RequestBody Customer customer) {
        System.out.println("ID : " + id);
        System.out.println("Name : " + customer.getName());
        System.out.println("Age : " + customer.getAge());
        System.out.println("Address : " + customer.getAddress());
        return new ResponseEntity<>("Customer Updated : " + id, HttpStatus.OK);
    }
}
