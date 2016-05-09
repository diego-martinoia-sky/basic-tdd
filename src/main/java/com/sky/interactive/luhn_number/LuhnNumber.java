package com.sky.interactive.luhn_number;

public interface LuhnNumber {

    void setNumber(int number);

    int getCheckDigit();

    int[] getAddends();

    int getCheckSum();

    boolean isValid();
}
