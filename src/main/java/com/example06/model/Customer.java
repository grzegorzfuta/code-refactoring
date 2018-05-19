package com.example06.model;

import java.util.List;

public interface Customer {
    String getName();
    List<Order> getOrderHistory();
}
