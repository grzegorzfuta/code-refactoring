package com.example03;

public class StringUtils2 {

    private static final Integer MAX_DESCRIPTION_LENGTH = 4000;

    public static String joinDescriptions(final String currentDescription, final String addedDescription) {
        try {
            String result = new String();

            if (currentDescription != null) {
                result = currentDescription.length() <= MAX_DESCRIPTION_LENGTH ?
                        currentDescription : currentDescription.substring(0, MAX_DESCRIPTION_LENGTH);
            }

            if (addedDescription == null) {
                return result;
            }

            if ((result.length() + addedDescription.length()) <= MAX_DESCRIPTION_LENGTH) {
                result += addedDescription;
            } else {
                Integer remainingCharacters = MAX_DESCRIPTION_LENGTH - result.length();
                if (remainingCharacters > 0) {
                    result += addedDescription.substring(0, remainingCharacters);
                }
            }

            return result;
        } catch (Exception exception) {
            String message = new String();
            if (currentDescription != null) {
                message += "1 DESCRIPTION: " + currentDescription;
            }
            if (addedDescription != null) {
                message += "2 DESCRIPTION: " + addedDescription;
            }
            throw new RuntimeException("ERROR ADDING DESCRIPTIONS: " + message);
        }
    }

}
