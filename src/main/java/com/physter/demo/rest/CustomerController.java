package com.physter.demo.rest;

import com.physter.demo.model.Customer;
import com.physter.demo.util.CustomerGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private static final int LIST_SIZE = 5;

    @Autowired
    private CustomerGenerator customerGenerator;

    @RequestMapping("/customers")
    public List<Customer> getCustomers() {
        List<Customer> customerList = new ArrayList<Customer>();
        for (int i = 0; i < LIST_SIZE; i++) {
            customerList.add(customerGenerator.generate());
        }
        return customerList;
    }
}
