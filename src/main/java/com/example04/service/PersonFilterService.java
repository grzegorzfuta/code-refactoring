package com.example04.service;

import com.example04.dto.PersonDto;

import javax.inject.Inject;
import java.util.*;

public class PersonFilterService implements FilterableMapper<PersonDto, String> {

    @Inject
    private ItemsService itemsService;

    @Override
    public Collection<String> filterBySurname(Collection<PersonDto> persons, final String name) {
        List<String> result = new ArrayList<>();
        for (PersonDto p : persons) {
            if (name.equals(p.getSurname())) {
                String email = p.getEmail();
                if (email != null)
                    result.add(email);
            }
        }
        return result;
    }

    @Override
    public Collection<String> filterByName(Collection<PersonDto> inputCol, String surname) {
        throw new UnsupportedOperationException("Method need to be implemented");
    }

    /**
     * Method returns persons ids that bought promoted items.
     * @param customers customers Ids to be included in filtering
     * @param items item codes to be filtered
     * @param date day for which prepare filtering
     * @return set of customers thatbought given item
     */
    public Set<Long> getCustomersOfGivenItem(Collection<Long> customers, Collection<String> items, Date date) {
        Set<Long> result = new HashSet<>();


        Map<Long, Collection<String>> data = itemsService.getPromotedItemsInGivenDay(date);

        for (Map.Entry<Long, Collection<String>> e : data.entrySet()) {
            for (String itemCode : items) {
                if (e.getValue().contains(itemCode) && customers.contains(e.getKey())) {
                    result.add(e.getKey());
                }
            }
        }

        return result;
    }

}
