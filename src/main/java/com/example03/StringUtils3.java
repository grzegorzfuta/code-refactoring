package com.example03;

public class StringUtils3 {

    private static final Integer MAX_DESCRIPTION_LENGTH = 4000;
    private static final String EMPTY_STRING = "";

    private static String nullToEmpty(String string) {
        return string == null ? EMPTY_STRING : string;
    }

    public static String joinDescriptions(final String description1, final String description2) {
        String description = nullToEmpty(description1) + nullToEmpty(description2);
        return description.length() <= MAX_DESCRIPTION_LENGTH ? description : description.substring(0, MAX_DESCRIPTION_LENGTH);
    }

}
