package com.example03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtils2Test {

    private static final String MAX_STRING = "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";

    @Test
    void joinNullAndNull() {
        String result = StringUtils2.joinDescriptions(null, null);
        assertEquals("", result);
        assertEquals(0, result.length());
    }

    @Test
    void joinNullAndNormalString() {
        String result = StringUtils2.joinDescriptions(null, "AAABBB");
        assertEquals("AAABBB", result);
        assertEquals(6, result.length());
    }


    @Test
    void joinNormalStringAndNull() {
        String firstString = new String("LoremIpsum");
        String result = StringUtils2.joinDescriptions(firstString, null);
        assertEquals(firstString, result);
        assertEquals(firstString.length(), result.length());
    }

    @Test
    void joinNullAndLongString() {
        String result = StringUtils2.joinDescriptions(null, new String(MAX_STRING + "ABCDEF"));
        assertEquals(MAX_STRING, result);
        assertEquals(4000, result.length());
    }

    @Test
    void joinLongStringAndNull() {
        String result = StringUtils2.joinDescriptions(new String(MAX_STRING + "ABCDEF"), null);
        assertEquals(MAX_STRING, result);
        assertEquals(4000, result.length());
    }

    @Test
    void joinLongStringAndNormalString() {
        String result = StringUtils2.joinDescriptions(new String(MAX_STRING + "ABCDEF"), "XXXX");
        assertEquals(MAX_STRING, result);
        assertEquals(4000, result.length());
    }

    @Test
    void joinNormalStringAndLongString() {
        String normalString = new String("XXXX");
        String result = StringUtils2.joinDescriptions(normalString, new String(MAX_STRING + "ABCDEF"));
        assertEquals(new String(normalString + MAX_STRING.substring(0, MAX_STRING.length() - normalString.length())), result);
        assertEquals(4000, result.length());
    }

    @Test
    void joinMaxStringAndNull() {
        String result = StringUtils2.joinDescriptions(new String(MAX_STRING), null);
        assertEquals(MAX_STRING, result);
        assertEquals(4000, result.length());
    }

    @Test
    void joinNullAndMaxString() {
        String result = StringUtils2.joinDescriptions(null, new String(MAX_STRING));
        assertEquals(MAX_STRING, result);
        assertEquals(4000, result.length());
    }

    @Test
    void joinLongStringAndLongString() {
        String result = StringUtils2.joinDescriptions(new String((MAX_STRING) + "AAAA"), new String(MAX_STRING + "BBBB"));
        assertEquals(MAX_STRING, result);
        assertEquals(4000, result.length());
    }

    @Test
    void joinNormalStringAndNormalString() {
        String result = StringUtils2.joinDescriptions("12345678901234", "AAAAABBBBBCCCCC");
        assertEquals("12345678901234AAAAABBBBBCCCCC", result);
    }

}
