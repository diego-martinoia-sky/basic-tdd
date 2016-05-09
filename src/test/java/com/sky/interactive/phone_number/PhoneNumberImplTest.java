package com.sky.interactive.phone_number;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberImplTest {

    PhoneNumber initPhoneNumber(String number) {
        PhoneNumber phoneNumber = new PhoneNumberImpl();
        phoneNumber.setNumber(number);
        return phoneNumber;
    }

    @Test
    public void cleansNumber() {
        final String expectedNumber = "1234567890";
        final String actualNumber = initPhoneNumber("(123) 456-7890").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Test
    public void cleansNumberWithDots() {
        final String expectedNumber = "1234567890";
        final String actualNumber = initPhoneNumber("123.456.7890").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Test
    public void validWhen11DigitsAndFirstIs1() {
        final String expectedNumber = "1234567890";
        final String actualNumber = initPhoneNumber("11234567890").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Test
    public void invalidWhenOnly11Digits() {
        final String expectedNumber = "0000000000";
        final String actualNumber = initPhoneNumber("21234567890").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Test
    public void invalidWhen9Digits() {
        final String expectedNumber = "0000000000";
        final String actualNumber = initPhoneNumber("123456789").getNumber();

        assertEquals(
                expectedNumber, actualNumber
        );
    }

    @Test
    public void areaCode() {
        final String expectedAreaCode = "123";
        final String actualAreaCode = initPhoneNumber("1234567890").getAreaCode();

        assertEquals(
                expectedAreaCode, actualAreaCode
        );
    }

    @Test
    public void prettyPrint() {
        final String expectedPrettyNumber = "(123) 456-7890";
        final String actualPrettyNumber = initPhoneNumber("1234567890").pretty();

        assertEquals(
                expectedPrettyNumber, actualPrettyNumber
        );
    }

    @Test
    public void prettyPrintWithFullUSPhoneNumber() {
        final String expectedPrettyNumber = "(123) 456-7890";
        final String actualPrettyNumber = initPhoneNumber("11234567890").pretty();

        assertEquals(
                expectedPrettyNumber, actualPrettyNumber
        );
    }
}