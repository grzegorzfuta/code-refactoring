package com.example04.service;

import java.util.Collection;

/**
 * Interface that defines possibility of filtering.
 * @param <IN> incoming type
 * @param <OUT> outgoing types
 */

public interface FilterableMapper<IN, OUT> {
    Collection<OUT> filterBySurname(Collection<IN> inputCol, String name);
    Collection<OUT> filterByName(Collection<IN> inputCol, String surname);
}
