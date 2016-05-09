package com.sky.interactive.luhn_number;

public interface LuhnNumber {

    static long create(long number) {
        return 0;
    }
    
    void setNumber(long number);

    long getCheckDigit();

    long[] getAddends();

    long getCheckSum();

    boolean isValid();
}
