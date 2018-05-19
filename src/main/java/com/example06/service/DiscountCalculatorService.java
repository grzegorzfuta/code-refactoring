package com.example06.service;

import com.example06.model.*;

import java.util.HashMap;
import java.util.Map;


public class DiscountCalculatorService {

    /**
     * Calculate discount for given Order and Customer
     * @param newOrder new Order with product positions
     * @param customer ordering customer
     * @return map of products with calculated discount
     */
    public Map<Product, Double> calculateDiscount(Order newOrder, Customer customer) {

        Map<Product, Double> discountList = new HashMap<>();

        if (customer instanceof NewCustomer) {
            Product cheapestProduct = null;
            for (OrderPosition position : newOrder.getOrderPositions()) {
                if (cheapestProduct == null || cheapestProduct.getSellingPrice() > position.getProduct().getSellingPrice()) {
                    cheapestProduct = position.getProduct();
                }
            }
            discountList.put(cheapestProduct, 1.02 * cheapestProduct.getPurchasePrice());
        } else if (customer instanceof IndividualCustomer) {
            for (OrderPosition position : newOrder.getOrderPositions()) {
                if (position.getProductCode().contains("X123")) {
                    discountList.put(position.getProduct(), 0.97 * position.getProduct().getSellingPrice());
                }
            }
        } else if (customer instanceof UnregisteredCustomer) {
            if (isPromocodeValid(newOrder.getPromoCode())) {
                for (OrderPosition position : newOrder.getOrderPositions()) {
                    discountList.put(position.getProduct(), 0.97 * position.getPrice());
                }
            }
        } else if (customer instanceof KeyAccountCustomer) {
            KeyAccountCustomer keyAccountCustomer = (KeyAccountCustomer) customer;
            for (OrderPosition position : newOrder.getOrderPositions()) {
                int percentDiscount = keyAccountCustomer.getPercentDiscountForCategory(position.getProduct().getCategoryCode());
                discountList.put(position.getProduct(), (100 - percentDiscount) * position.getPrice());
            }
        } else if (customer instanceof CorporateCustomer) {
            CorporateCustomer corporateCustomer = (CorporateCustomer) customer;
            long amountofPOS = corporateCustomer.getNumberOfPOS();
            int percentDiscount = discountForNUmberOfPOS(amountofPOS);

            for (OrderPosition position : newOrder.getOrderPositions()) {
                discountList.put(position.getProduct(), (100 - percentDiscount) * position.getPrice());
            }
        }

        return discountList;
    }

    private boolean isPromocodeValid(String promoCode) {
        // mocked implementation
        return true;
    }

    private int discountForNUmberOfPOS(long numberOfPos) {
        // some complicated logic here ;)
        if (numberOfPos > 30) {
            return 7;
        }
        return 2;
    }

}
