package com.joe.isbntool;

public class ValidateISBN {

    public static final int LONG_ISBN = 13;
    public static final int SHORT_ISBN = 10;
    public static final int Long_ISBN_MULTIPLIER = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;

    public boolean checkISBN(String isbn) {
        if (isbn.length() == LONG_ISBN) {
            return isValidLongDigitISBN(isbn);
        } else if (isbn.length() == SHORT_ISBN) {
            return isValidShortDigitNumber(isbn);
        }

        throw new NumberFormatException("ISBN number should be 10 or 13 digits long");
    }

    private boolean isValidShortDigitNumber(String isbn) {

        int total = 0;
        for (int i = 0; i < SHORT_ISBN; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    //this is okay
                    total += SHORT_ISBN;
                } else
                    throw new NumberFormatException("ISBN numbers can only contain numeric digits");
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN - i);
            }
        }
        return (total % SHORT_ISBN_MULTIPLIER == 0);
    }

    private boolean isValidLongDigitISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN; i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));

            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }
        return (total % Long_ISBN_MULTIPLIER == 0);
    }

}
