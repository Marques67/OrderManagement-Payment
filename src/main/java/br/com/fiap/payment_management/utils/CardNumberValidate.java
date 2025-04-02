package br.com.fiap.payment_management.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardNumberValidate {

    public static boolean isAValidCardNumber(String cardNumber) {
        String cardFormat = "^\\d{4}[- ]\\d{4}[- ]\\d{4}[- ]\\d{4}$";
        Pattern cardPattern = Pattern.compile(cardFormat);
        Matcher cardMatcher = cardPattern.matcher(cardNumber);

        if (cardMatcher.matches()) {
            String completedNumber = cardNumber.replaceAll("[ -]", "");

            return completedNumber.length() == 16;
        } else {
            return false;
        }
    }
}
