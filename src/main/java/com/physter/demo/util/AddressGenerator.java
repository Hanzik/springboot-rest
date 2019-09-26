package com.physter.demo.util;

import com.physter.demo.model.Address;
import com.physter.demo.properties.AddressMockData;
import com.physter.demo.properties.CustomerMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@EnableConfigurationProperties({CustomerMockData.class, AddressMockData.class})
public class AddressGenerator {

    private final AddressMockData addressMockData;

    private Random rand = new Random();

    @Autowired
    public AddressGenerator(AddressMockData addressMockData) {
        this.addressMockData = addressMockData;
    }

    public Address generate() {
        return new Address(getRandomStreet(), getRandomCity(), getRandomZipCode(), "CZ");
    }

    private String getRandomStreet() {
        return addressMockData.getStreets()[rand.nextInt(addressMockData.getStreets().length)];
    }

    private String getRandomCity() {
        return addressMockData.getCities()[rand.nextInt(addressMockData.getCities().length)];
    }

    private String getRandomZipCode() {
        return String.format("%03d %02d", rand.nextInt(1000), rand.nextInt(100));
    }
}
