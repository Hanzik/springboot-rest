package com.physter.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("data.address")
public class AddressMockData {

    private String[] streets;
    private String[] cities;

    public String[] getStreets() {
        return streets;
    }

    public void setStreets(String[] streets) {
        this.streets = streets;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }
}
