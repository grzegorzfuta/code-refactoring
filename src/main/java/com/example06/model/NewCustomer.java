package com.example06.model;

import java.util.ArrayList;
import java.util.List;

public class NewCustomer implements Customer {

    @Override
    public String getName() {
        return "NewCustomer nam";
    }

    @Override
    public List<Order> getOrderHistory() {
        return new ArrayList<>();
    }

    public boolean isNewbeDiscount() {
        return true;
    }
}
