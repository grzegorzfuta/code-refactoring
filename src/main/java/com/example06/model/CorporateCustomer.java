package com.example06.model;

import java.util.List;

public class CorporateCustomer implements Customer {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<Order> getOrderHistory() {
        return null;
    }

    public String getTaskIdentificationNumber() {
        return "555-123-45-67";
    }

    public Integer getNumberOfPOS() {
        return 12;
    }
}
