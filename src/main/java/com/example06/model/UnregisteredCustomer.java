package com.example06.model;

import java.util.ArrayList;
import java.util.List;

public class UnregisteredCustomer implements Customer {

    @Override
    public String getName() {
        return "NewCustomer nam";
    }

    @Override
    public List<Order> getOrderHistory() {
        return new ArrayList<>();
    }

    public String getShihpmentAddress() {
        return "some shipment address";
    }

    public String getContactPhone() {
        return "555-501-591";
    }

    public String getEmail() {
        return "dev@null.org";
    }
}
