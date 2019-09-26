package com.physter.demo.util;

import com.physter.demo.model.Customer;
import com.physter.demo.properties.AddressMockData;
import com.physter.demo.properties.CustomerMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
@EnableConfigurationProperties({CustomerMockData.class, AddressMockData.class})
public class CustomerGenerator {

    private final CustomerMockData customerMockData;

    private Random rand = new Random();

    @Autowired
    private AddressGenerator addressGenerator;

    @Autowired
    public CustomerGenerator(CustomerMockData customerMockData) {
        this.customerMockData = customerMockData;
    }

    public Customer generate() {
        String firstName = getRandomFirstName();
        String lastName = getRandomLastName(firstName);
        return new Customer(UUID.randomUUID().toString(), firstName, lastName, getRandomContractNumber(), addressGenerator.generate());
    }

    private String getRandomContractNumber() {
        return "CZ" + String.format("%07d", rand.nextInt(1000000));
    }

    private String getRandomFirstName() {
        return customerMockData.getFirstNames()[rand.nextInt(customerMockData.getFirstNames().length)];
    }

    private String getRandomLastName(String firstName) {
        boolean female = firstName.matches("(.*)[ae]");
        int index = rand.nextInt(customerMockData.getLastNames().length - 1);
        if (female && index % 2 == 1|| !female && index % 2 == 0) {
            index++;
        }
        return customerMockData.getLastNames()[index];
    }
}
