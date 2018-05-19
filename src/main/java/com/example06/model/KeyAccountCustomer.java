package com.example06.model;

import java.util.List;

public class KeyAccountCustomer implements Customer {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<Order> getOrderHistory() {
        return null;
    }

    public String getSupervisorCode() {
        return "007";
    }

    public int getPercentDiscountForCategory(String category) {
        if (category.contains("A10")) {
            return 5;
        } else if (category.contains("C20")) {
            return 7;
        } else if (category.contains("B55")) {
            return 9;
        }
        return 4;
    }

}
