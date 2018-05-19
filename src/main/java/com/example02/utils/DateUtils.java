package com.example02.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * Formatuje date do zadanego formatu
     *
     * @param date
     *      Formatowana data
     * @param pattern
     *      Pattern do jakiego zostanie sformatowana data
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        try {
            return format(date, pattern);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    private static String format(final Date date, final String pattern) {
        return getFormater(pattern).format(date);
    }

    /**
     * Pobiera instancje formatera dla zadanego patternu
     * Jesli nie byl wczesniej uzywany - tworzy nowy
     * @param pattern
     * @return
     */
    public static final SimpleDateFormat getFormater(final String pattern) {
        // fixme
        return new SimpleDateFormat(pattern);
    }
}
