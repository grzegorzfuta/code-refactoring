package com.example04;

import com.example04.dto.PersonDto;
import com.example04.service.PersonFilterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonFilterServiceTest {

    private PersonFilterService personFilter = new PersonFilterService();

    private static final List<PersonDto> EMPTY_PERSON_LIST = Arrays.asList();

    private static final List<PersonDto> THREE_PERSON_LIST = Arrays.asList(
            new PersonDto("Jon", "Doe"),
            new PersonDto("Ciamcia", "Ramcia"),
            new PersonDto("Gromosław", "Faserasd")
    );

    @Test
    public void shouldNotThereBeRefectorBeforeTestsAreWritten() {
        assertEquals("TAK", "NIE", "Czy są testy? Bez testów nie refactorujemy.");
    }

    @Test
    public void shouldReturnValidFilteredEmails() {
        // todo IMPLEMENT TEST
        // todo gf napisz prosty test w branchu obok
    }


    @ParameterizedTest
    @MethodSource("returnPersonList")
    public void shouldThrowExceptionOnFilteringByName(Collection<PersonDto> testList) {
        assertThrows(UnsupportedOperationException.class, () -> {
            personFilter.filterByName(testList, "zcx");
        });
    }

    private static Object[] returnPersonList() {
        return new Object[]{
                new Object[]{EMPTY_PERSON_LIST},
                new Object[]{THREE_PERSON_LIST}
//                new Object[]{22, true}
        };
    }

}
