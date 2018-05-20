package com.example03;

public class StringUtils1 {

    private static final Integer MAX_DESCRIPTION_LENGTH = 4000;

    /**
     * @param currentDescription - current description
     * @param addedDescription   - added description
     * @return added descriptions with maximum length of MAX_DESCRIPTION_LENGTH
     */
    public static String joinDescriptions(final String currentDescription, final String addedDescription) {
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
            result += addedDescription.substring(0, remainingCharacters);
        }

        return result;
    }

}
