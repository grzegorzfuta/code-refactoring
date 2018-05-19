package com.example02.utils;

public class StringUtils {
    /**
     * Stała reprezentująca pusty String
     */
    public static final String EMPTY = "";


    /**
     * Stała reprezentująca pusty String
     */
    public static final String BRAK = "---";


    /**
     * Stała reprezentująca pusty String
     */
    public static final String ZERO = "0";

    public static String padWithZeroes(String aS, int aLength) {
        while (aS.length() < aLength) {
            aS = "0" + aS;
        }
        return aS;
    }

    public static String padWithZeroes(Number aN, int aLength) {
        String s = EMPTY + aN;
        while (s.length() < aLength) {
            s = "0" + s;
        }
        return s;
    }

}
