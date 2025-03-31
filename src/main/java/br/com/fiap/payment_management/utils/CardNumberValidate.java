package br.com.fiap.payment_management.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardNumberValidate {

    public static boolean isAValidCardNumber(String cardNumber) {
        String regex = "^\\d{4} \\d{4} \\d{4} \\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);

        if (matcher.matches()) {
            String completedNumber = cardNumber.replaceAll("[ -]", "");

            return completedNumber.length() == 16;
        } else {
            return false;
        }
    }
}
