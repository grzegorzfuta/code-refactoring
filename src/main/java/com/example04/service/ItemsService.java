package com.example04.service;

import java.util.*;


class ItemsService {

    /**
     * Returns map if customer ids and colelction of codes of bought items in given day.
     * @param day day for which data should be returned
     * @return collection of customerIDS and bought item codes
     */
    public Map<Long, Collection<String>> getPromotedItemsInGivenDay(Date day) {
        return new HashMap<>(); // mocked implementation
    }
}
