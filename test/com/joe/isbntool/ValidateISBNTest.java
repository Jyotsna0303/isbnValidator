package com.joe.isbntool;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {
    @Test
    public void checkAValid10DigitISBN() {
        //1st step to run the fail method
        // fail("Not yet implemented");
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue(result);
        //checking for the second method
        result = validator.checkISBN("1847941834");
        assertTrue(result);
    }

    @Test
    public void checkAn10DigitIValidISBN() {
        // fail("Not yet implemented");
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449118");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNAreNotAllowed() {
        // fail("Not yet implemented");
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("140449118");
    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericISBNNotAllowed() {
        // fail();
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("helloworld");
    }

    @Test
    public void lastDigit10DigitISBNCanBeX() {
        // fail("Not yet implemented");
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("178633089X");
        assertTrue(result);
    }

    @Test
    public void checkAValid13DigitISBN() {
        //fail();
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781786330895");
        assertTrue(result);
    }

    @Test
    public void checkAn13DigitIValidISBN() {
        // fail("Not yet implemented");
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781786330896");
        assertFalse(result);
    }
}

