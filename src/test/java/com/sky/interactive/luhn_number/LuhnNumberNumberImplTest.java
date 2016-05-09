package com.sky.interactive.luhn_number;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class LuhnNumberNumberImplTest {

    LuhnNumber initLuhnNumber(int number) {
        LuhnNumber luhnNumber = new LuhnNumberImpl();
        luhnNumber.setNumber(number);
        return luhnNumber;
    }

    @Test
    public void checkDigitIsRightMostDigit() {
        LuhnNumber luhnNumber = initLuhnNumber(34567);
        int expectedOutput = 7;

        assertEquals(expectedOutput, luhnNumber.getCheckDigit());
    }

    @Test
    public void addendsDoublesEveryOtherNumberFromRight() {
        LuhnNumber luhnNumber = initLuhnNumber(12121);
        int[] expectedOutput = new int[]{1, 4, 1, 4, 1};

        assertArrayEquals(expectedOutput, luhnNumber.getAddends());
    }

    @Test
    public void addendsSubtracts9WhenDoubledNumberIsMoreThan9() {
        LuhnNumber luhnNumber = initLuhnNumber(8631);
        int[] expectedOutput = new int[]{7, 6, 6, 1};

        assertArrayEquals(expectedOutput, luhnNumber.getAddends());
    }

    @Test
    public void checkSumAddsAddendsTogether1() {
        LuhnNumber luhnNumber = initLuhnNumber(4913);
        int expectedOutput = 22;

        assertEquals(expectedOutput, luhnNumber.getCheckSum());
    }

    @Test
    public void checkSumAddsAddendsTogether2() {
        LuhnNumber luhnNumber = initLuhnNumber(201773);
        int expectedOutput = 21;

        assertEquals(expectedOutput, luhnNumber.getCheckSum());
    }

    @Test
    public void numberIsValidWhenChecksumMod10IsZero1() {
        LuhnNumber luhnNumber = initLuhnNumber(738);
        boolean expectedOutput = false;

        assertEquals(expectedOutput, luhnNumber.isValid());
    }

    @Test
    public void numberIsValidWhenChecksumMod10IsZero2() {
        LuhnNumber luhnNumber = initLuhnNumber(8739567);
        boolean expectedOutput = true;

        assertEquals(expectedOutput, luhnNumber.isValid());
    }

    @Test
    public void luhnNumberCanCreateSimpleNumbersWithValidCheckDigit() {
        long expectedOutput = 1230;

        assertEquals(expectedOutput, LuhnNumberImpl.create(123));
    }

    @Test
    public void luhnNumberCanCreateLargeNumbersWithValidCheckDigit() {
        long expectedOutput = 8739567;

        assertEquals(expectedOutput, LuhnNumberImpl.create(873956));
    }

    @Test
    public void luhnNumberCanCreateHugeNumbersWithValidCheckDigit() {
        long expectedOutput = 8372637564L;

        assertEquals(expectedOutput, LuhnNumberImpl.create(837263756));
    }
}
